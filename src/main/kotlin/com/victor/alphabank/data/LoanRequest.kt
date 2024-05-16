package com.victor.springdemo.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("LoanRequest")
data class LoanRequest(
    @Id var id: String? = null,
    val status: String,
    @Column("max_amount") val maxAmount: Long?,
    val userId: String,
)