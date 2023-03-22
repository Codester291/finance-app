package com.ai.doye.financeapp.repository

import com.ai.doye.financeapp.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {
    fun findByAccountNo(accountNo: String) : Account
}