package com.example.chat.repository

import com.example.chat.entity.ChatRoom
import org.springframework.stereotype.Repository

@Repository
class ChatRoomRepository {

    private val chatRooms = mutableListOf<ChatRoom>()

    fun createChatRoomDTO(name: String): ChatRoom {
        val chatRoom = ChatRoom(name = name)
        chatRooms.add(chatRoom)
        return chatRoom
    }

    fun findAllRooms(): List<ChatRoom> {
        return chatRooms
    }

    fun findRoomById(id: String): ChatRoom? {
        return chatRooms.find { it.id == id }
    }
}