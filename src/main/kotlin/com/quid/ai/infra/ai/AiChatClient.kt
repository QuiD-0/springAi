package com.quid.ai.infra.ai

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.stereotype.Component

@Component
class AiChatClient(
    private val chatClient: ChatClient
) {

    fun chat(prompt: Prompt) = chatClient.prompt(prompt).call().chatResponse()!!

    fun stream(prompt: Prompt) = chatClient.prompt(prompt).stream().chatResponse()
}
