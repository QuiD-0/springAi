package com.quid.ai.infra.http

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.chat.prompt.PromptTemplate
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
        val promptTemplate =
            PromptTemplate("""
                you are java, spring specialist and you are a good teacher. 
                I am a student and I want to learn java from you. Can you teach me?
                my question is { question }
            """.trimIndent())
        promptTemplate.add("question", message.text)
        val create = promptTemplate.create()
        return chatClient
            .prompt(create)
            .stream()
            .chatResponse()
    }
}

data class Message(val text: String)
