package com.quid.ai.domain

enum class PromptType {
    DEFAULT, SPRING_MASTER, JAVA_MASTER;

    companion object {
        fun findByName(value: String): PromptType {
            return entries.firstOrNull { it.name == value } ?: DEFAULT
        }
    }
}
