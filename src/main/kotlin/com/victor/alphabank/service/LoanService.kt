package com.victor.alphabank.service

import com.victor.alphabank.data.LoanRequest
import com.victor.alphabank.data.User
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*

@Service
class LoanService(val db: JdbcTemplate) {

    fun findUsers(): List<User> = db.query("SELECT * FROM `user`") { response, _ ->
        User(
            response.getString("ID"),
            response.getString("name"),
            response.getInt("Age"),
            response.getLong("MonthIncome"),
            response.getString("City")
        )
    }

    fun findUserById(id: String): List<User> =
        db.query("SELECT * FROM `user` WHERE id = ?", id) { response, _ ->
            User(
                response.getString("ID"),
                response.getString("name"),
                response.getInt("Age"),
                response.getLong("MonthIncome"),
                response.getString("City")
            )
        }

    fun saveUser(user: User): String {
        val id = user.id ?: UUID.randomUUID().toString()
        db.update(
            "INSERT INTO `user` VALUES ( ?, ?, ?, ?, ?)",
            id, user.name, user.age, user.monthIncome, user.city
        )

        return id
    }

    fun saveLoan(loanRequest: LoanRequest): LoanRequest {
        val id = loanRequest.id ?: UUID.randomUUID().toString()
        db.update(
            "INSERT INTO loanrequest VALUES ( ?, ?, ?, ?)",
            id, loanRequest.status, loanRequest.maxAmount, loanRequest.userId
        )

        return loanRequest.copy(
            id = id
        )
    }
}