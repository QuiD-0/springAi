package com.quid.ai.infra.http

import com.quid.ai.domain.AiService
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class Controller(
    private val aiService: AiService
) {

    @PostMapping("/chat")
    fun chat(@RequestBody message: MessageRequest): ChatResponse {
        return aiService.chat(message.toChatRequest())
    }

    @PostMapping("/stream")
    fun stream(@RequestBody message: MessageRequest): Flux<ChatResponse> {
        return aiService.stream(message.toChatRequest())
    }
}

