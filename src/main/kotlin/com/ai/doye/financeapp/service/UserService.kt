package com.ai.doye.financeapp.service

import com.ai.doye.financeapp.dto.ResponseDTO
import com.ai.doye.financeapp.dto.UserDTO
import com.ai.doye.financeapp.model.User
import com.ai.doye.financeapp.repository.UserRepository
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class UserService(
        var userRepository: UserRepository,
        val logger: KLogger = KotlinLogging.logger {}
) {

    fun createUser(userDTO: UserDTO): ResponseDTO {
        return try {
            val user = User()
            user.firstName = userDTO.firstName
            user.lastName = userDTO.lastName
            user.username = userDTO.username
            //TODO: call a createAccount(User) method

            ResponseDTO("00", "Success", userRepository.save(user))
        } catch (e: Exception) {
            logger.info("Error occurred in {}", e.message)
            ResponseDTO("XX", "Could not register user at the moment, please try again in few minutes")
        }
    }
}