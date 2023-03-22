package com.ai.doye.financeapp.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        var username: String,
        var firstName: String,
        var lastName: String,

        @OneToOne(mappedBy = "user")
        @JsonManagedReference
        var account: Account?
) {
        constructor() : this(1L, "", "", "", null)

        fun fullName(): String {
                return "$firstName $lastName"
        }
}