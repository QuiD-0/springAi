package com.quid.ai.infra.http

import org.springframework.ai.chat.client.ChatClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val chatClient: ChatClient
) {

    @PostMapping("/chat")
    fun chat(@RequestBody message: Message) {
        chatClient
            .prompt(message.text)
            .call()
            .chatResponse()
            .also { println(it) }
    }
}

data class Message(val text: String)
