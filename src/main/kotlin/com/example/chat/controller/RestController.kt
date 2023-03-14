package com.example.chat.controller

import com.example.chat.entity.ChatRoom
import com.example.chat.repository.ChatRoomRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class RestController(private val chatRoomRepository: ChatRoomRepository) {

    @GetMapping("/chat-rooms")
    fun chatRooms() = chatRoomRepository.findAllRooms()

    @PostMapping("/chat-rooms")
    fun createChatRoom(@RequestBody name: String) = chatRoomRepository.createChatRoomDTO(name)

    @GetMapping("/chat-rooms/{id}")
    fun getChatRoom(@RequestParam id: String) = chatRoomRepository.findRoomById(id)

}