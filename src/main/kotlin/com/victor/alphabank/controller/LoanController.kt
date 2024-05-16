package com.victor.springdemo.controller

import com.victor.springdemo.data.LoanRequest
import com.victor.springdemo.data.User
import com.victor.springdemo.service.LoanService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoanController(val service: LoanService) {

    @GetMapping("/")
    fun index(): List<User> = service.findUsers()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<User> = service.findUserById(id)

    @PostMapping("/")
    private fun post(@RequestBody user: User): LoanRequest {
        val userId = service.saveUser(user)

        val loanRequest = if (user.monthIncome > 5000) {
            LoanRequest(status = "APPROVED", maxAmount = user.monthIncome * 3, userId = userId)
        } else {
            LoanRequest(status = "DENIED", maxAmount = null, userId = userId)
        }
        return service.saveLoan(loanRequest)
    }

//    @GetMapping("/request-loan")
//    fun requestLoan(
//        @RequestParam("name") name: String
//    ) = service.requestLoan(name)

//    @GetMapping("/user")
//    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}
