package com.quid.ai.domain

data class ChatRequest(
    val message: String,
    val type: PromptType
)
