package com.example.chat.controller

import com.example.chat.common.Log
import com.example.chat.entity.ChatRoom
import com.example.chat.repository.ChatRoomRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class ViewController(private val chatRoomRepository: ChatRoomRepository) : Log {
    @GetMapping("/chat-sock")
    fun chatSock(): String {
        return "chat_sockjs"
    }

    @GetMapping("/chat-stomp")
    fun chatStomp(): String {
        return "chat_stompjs"
    }

    //채팅방 목록 조회
    @GetMapping(value = ["/rooms"])
    fun rooms(): ModelAndView? {
        logger.info("# All Chat Rooms")
        val mv = ModelAndView("chat/rooms")
        mv.addObject("list", chatRoomRepository.findAllRooms())
        return mv
    }

    //채팅방 개설
    @PostMapping("/chat/room")
    fun create(@RequestParam name: String, rttr: RedirectAttributes): String? {
        logger.info("# Create Chat Room , name: $name")
        rttr.addFlashAttribute("room", chatRoomRepository.createChatRoomDTO(name))
        return "redirect:/room"
    }

    //채팅방 조회
    @GetMapping("/room")
    fun getRoom(model: Model): ModelAndView? {
        val room = model.asMap()["room"] as ChatRoom
        logger.info("# get Chat Room, roomID : ${room.id}")
        val mv = ModelAndView("chat/room")
        mv.addObject("room", chatRoomRepository.findRoomById(room.id))
        return mv
    }

    @GetMapping("/chat2")
    fun chat2(): String {
        return "chat2/chat2"
    }

}