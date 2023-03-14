package com.example.chat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChatExampleApplication

fun main(args: Array<String>) {
    runApplication<ChatExampleApplication>(*args)
}
