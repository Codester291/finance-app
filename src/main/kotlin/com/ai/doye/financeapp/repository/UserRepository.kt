package com.ai.doye.financeapp.repository

import com.ai.doye.financeapp.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>