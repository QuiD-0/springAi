package com.quid.ai.domain

import org.springframework.ai.chat.prompt.PromptTemplate

sealed interface PromptMessage {
    fun prompt(message: String): PromptTemplate
}

data object JavaMaster : PromptMessage {
    override fun prompt(message: String): PromptTemplate {
        return PromptTemplate(
            """
            you are java specialist and you are a good teacher. 
            I am a student and I want to learn java from you. Can you teach me?
            my question is $message
        """.trimIndent()
        )
    }
}

data object SpringMaster : PromptMessage {
    override fun prompt(message: String): PromptTemplate {
        return PromptTemplate(
            """
            you are java specialist and you are a good teacher. 
            I am a student and I want to learn java from you. Can you teach me?
            my question is $message
        """.trimIndent()
        )
    }
}

data object DefaultTemplate : PromptMessage {
    override fun prompt(message: String): PromptTemplate {
        return PromptTemplate(
            """
            my question is $message
        """.trimIndent()
        )
    }
}
