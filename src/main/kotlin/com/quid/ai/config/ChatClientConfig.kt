package com.quid.ai.config

import org.springframework.ai.chat.client.ChatClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatClientConfig(
    private val chatClient: ChatClient.Builder
) {

    @Bean
    fun chatClient(): ChatClient {
        return chatClient.build()
    }
}
