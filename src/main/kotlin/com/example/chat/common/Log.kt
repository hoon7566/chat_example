package com.example.chat.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Log {
    val logger: Logger
        get() = LoggerFactory.getLogger(this.javaClass)
}