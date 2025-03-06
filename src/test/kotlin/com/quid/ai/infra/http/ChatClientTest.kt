package com.quid.ai.infra.http

import org.junit.jupiter.api.Test
import org.springframework.ai.chat.client.ChatClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import java.util.concurrent.CountDownLatch

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = ALL)
class ChatClientTest(
    private val chatClient: ChatClient
) {

    @Test
    fun callTest() {
        val message = """
                Who Are You?                               
            """.trimIndent()
        chatClient.prompt(message).call().chatResponse()
            .also { println(it) }
    }

    @Test
    fun streamTest() {
        val countDownLatch = CountDownLatch(1)

        val message = """
                Who Are You?                               
            """.trimIndent()

        chatClient.prompt(message)
            .stream()
            .chatResponse()
            .log()
            .doOnComplete { countDownLatch.countDown() }
            .subscribe()

        countDownLatch.await()
    }
}
