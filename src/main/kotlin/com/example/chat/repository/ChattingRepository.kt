package com.example.chat.repository

import com.example.chat.entity.Chatting
import org.springframework.stereotype.Repository

@Repository
class ChattingRepository {
    private val chatting = mutableListOf<Chatting>()

    fun createChatting(chatting: Chatting): Chatting {
        val chatting = Chatting(chatRoomId = chatting.chatRoomId, message = chatting.message, writer = chatting.writer)
        this.chatting.add(chatting)
        return chatting
    }
    fun findAllChatting(): List<Chatting> {
        return chatting
    }

    fun findChattingById(id: String): Chatting? {
        return chatting.find { it.chatRoomId == id }
    }
}