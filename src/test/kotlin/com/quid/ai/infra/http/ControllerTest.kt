package com.quid.ai.infra.http

import org.junit.jupiter.api.Test
import org.springframework.ai.chat.client.ChatClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = ALL)
class ControllerTest(
    private val chatClient: ChatClient
) {

    @Test
    fun callTest() {
        val message = """
                Who Are You?                               
            """.trimIndent()
        println(chatClient.prompt(message).call().chatResponse())
    }
}
