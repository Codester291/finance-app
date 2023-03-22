package com.ai.doye.financeapp.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
data class Account (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        var accountNo: String,
        var balance: Double,

        @OneToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        @JsonBackReference
        var user: User?
) {
        constructor() : this(1L, "", 0.0, null)
}