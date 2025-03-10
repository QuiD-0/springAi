package com.quid.ai.infra.http

import com.quid.ai.domain.ChatRequest
import com.quid.ai.domain.PromptType

data class MessageRequest(val text: String, val type: String = "DEFAULT") {
    fun toChatRequest(): ChatRequest {
        return ChatRequest(text, PromptType.findByName(type))
    }
}
