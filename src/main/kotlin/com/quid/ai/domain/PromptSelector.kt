package com.quid.ai.domain

import com.quid.ai.domain.PromptType.DEFAULT
import com.quid.ai.domain.PromptType.JAVA_MASTER
import com.quid.ai.domain.PromptType.SPRING_MASTER
import org.springframework.ai.chat.prompt.Prompt

object PromptSelector {
    fun prompt(message: String, type: PromptType): Prompt {
        return when (type) {
            SPRING_MASTER -> SpringMaster
            JAVA_MASTER -> JavaMaster
            DEFAULT -> DefaultTemplate
        }.prompt(message).create()
    }
}

