package com.ai.doye.financeapp.model

import jakarta.persistence.*

@Entity
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        var username: String,
        var firstName: String,
        var lastName: String

//        @OneToOne(fetch = FetchType.LAZY,
//                cascade = [CascadeType.ALL],
//                mappedBy = "user")
//        val account: Account?
) {
        constructor() : this(1L, "", "", "")

        fun fullName(): String {
                return "$firstName $lastName"
        }
}