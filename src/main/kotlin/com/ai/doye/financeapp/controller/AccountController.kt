package com.ai.doye.financeapp.controller

import com.ai.doye.financeapp.dto.FundDTO
import com.ai.doye.financeapp.dto.ResponseDTO
import com.ai.doye.financeapp.dto.TransferDTO
import com.ai.doye.financeapp.service.AccountService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController(
        val accountService: AccountService
) {

    @PostMapping("/fund")
    fun fundAccount(@RequestBody fundDTO: FundDTO): ResponseDTO {
        return accountService.fundAccount(fundDTO)
    }

    @PostMapping("/transfer")
    fun transfer(
            @RequestBody transferDTO: TransferDTO,
            @RequestParam accountNo: String): ResponseDTO {
        return accountService.transfer(transferDTO, accountNo)
    }
}