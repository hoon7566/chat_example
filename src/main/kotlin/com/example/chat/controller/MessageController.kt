package com.example.chat.controller

import com.example.chat.entity.Chatting
import com.example.chat.repository.ChattingRepository
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class MessageController(private val template: SimpMessagingTemplate, private val chattingRepository: ChattingRepository) {

    @MessageMapping("/chat")
    fun chat(payload: Chatting) {
        chattingRepository.createChatting(payload)
        template.convertAndSend("/queue/chat", payload)
    }


}