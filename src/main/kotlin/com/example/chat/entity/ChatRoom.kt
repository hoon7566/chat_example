package com.example.chat.entity

import java.util.UUID.randomUUID


data class ChatRoom (
    val id: String = randomUUID().toString(),
    val name: String

)