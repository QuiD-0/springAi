package com.quid.ai.domain

import com.quid.ai.domain.PromptType.DEFAULT
import com.quid.ai.infra.ai.AiChatClient
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class AiService(
    private val aiChatClient: AiChatClient
) {
    private val selector: PromptSelector = PromptSelector

    fun chat(chat: ChatRequest): ChatResponse {
        val prompt = selector.prompt(chat.message, chat.type)
        return aiChatClient.chat(prompt)
    }

    fun stream(chat: ChatRequest): Flux<ChatResponse> {
        val prompt = selector.prompt(chat.message, chat.type)
        return aiChatClient.stream(prompt)
    }

    fun now(): ChatResponse {
        val tools = DateTimeTools()
        val prompt = selector.prompt("What time is it?", DEFAULT)
        return aiChatClient.chat(prompt, tools)
    }
}

