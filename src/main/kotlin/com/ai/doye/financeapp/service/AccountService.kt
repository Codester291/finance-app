package com.ai.doye.financeapp.service

import com.ai.doye.financeapp.dto.FundDTO
import com.ai.doye.financeapp.dto.ResponseDTO
import com.ai.doye.financeapp.dto.TransferDTO
import com.ai.doye.financeapp.model.Account
import com.ai.doye.financeapp.model.User
import com.ai.doye.financeapp.repository.AccountRepository
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.lang.String.format

@Service
class AccountService(
        val accountRepository: AccountRepository,
        val logger: KLogger = KotlinLogging.logger {}
) {

    fun createAccount(user: User): Boolean {
        try{
            val account = Account()
            account.balance = 0.0
            account.accountNo = generateAccountNo()
            account.user = user

            accountRepository.save(account)
            return true
        } catch (e: Exception) {
            logger.info("Exception occurred in [createAccount] method {}", e.message)
        }
        return false
    }

    fun fundAccount(fundDTO: FundDTO): ResponseDTO {
        return try {
            val account = accountRepository.findByAccountNo(fundDTO.accountNo)

            account.balance += fundDTO.amount
            accountRepository.save(account)

            ResponseDTO("00","Account funded successfully")
        } catch (e: Exception) {
            logger.info("Exception occurred in [fundAccount] method")
            ResponseDTO("XX", "Failed Funding Operation")
        }
    }

    fun transfer(transferDTO: TransferDTO, accountNo: String): ResponseDTO {
        return try {
            val senderAccount = accountRepository.findByAccountNo(accountNo)
            val recipientAccount = accountRepository.findByAccountNo(transferDTO.recipientAccountNo)

            if(transferDTO.amount > senderAccount.balance) {
                ResponseDTO("98", "Insufficient Balance to perform transfer")
            }

            senderAccount.balance -= transferDTO.amount
            recipientAccount.balance += transferDTO.amount

            accountRepository.save(senderAccount)
            accountRepository.save(recipientAccount)

            ResponseDTO("00","Transfer to ${recipientAccount.user?.fullName()} funded successfully")
        } catch (e: Exception) {
            logger.info("Exception occurred in [fundAccount] method")
            ResponseDTO("XX", "Failed Transfer Operation")
        }
    }

    fun generateAccountNo(): String {
        val currentTimeSeconds = System.currentTimeMillis() / 1000
        return format("%s", currentTimeSeconds)
    }
}