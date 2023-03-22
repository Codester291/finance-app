package com.ai.doye.financeapp.service

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

    fun generateAccountNo(): String {
        return format("%s", System.currentTimeMillis())
    }
}