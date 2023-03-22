package com.ai.doye.financeapp.controller

import com.ai.doye.financeapp.dto.ResponseDTO
import com.ai.doye.financeapp.dto.UserDTO
import com.ai.doye.financeapp.service.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
        val userService: UserService
) {

    @PostMapping(value = ["/register"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createUser(@RequestBody userDTO: UserDTO): ResponseDTO {
        return userService.createUser(userDTO);
    }
}