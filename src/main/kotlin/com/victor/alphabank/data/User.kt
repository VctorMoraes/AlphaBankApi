package com.victor.alphabank.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("User")
data class User(
    @Id var id: String?,
    val name: String,
    val age: Int,
    val monthIncome: Long,
    val city: String
)