package com.quid.ai.infra.http

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class Controller(
    private val chatClient: ChatClient
) {

    @PostMapping("/chat")
    fun chat(@RequestBody message: Message): ChatResponse {
        return chatClient
            .prompt(message.text)
            .call()
            .chatResponse()!!
    }

    @PostMapping("/stream")
    fun stream(@RequestBody message: Message): Flux<ChatResponse> {
        return chatClient
            .prompt(message.text)
            .stream()
            .chatResponse()
    }
}

data class Message(val text: String)
