package com.ai.doye.financeapp.model

import jakarta.persistence.*

@Entity
class Account (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        val accountNo: String,
        val balance: Double

//        @OneToOne(fetch = FetchType.LAZY, optional = false)
//        @JoinColumn(name = "user_id", nullable = false)
//        val user: User?
) {
        constructor() : this(1L, "", 0.0)
}