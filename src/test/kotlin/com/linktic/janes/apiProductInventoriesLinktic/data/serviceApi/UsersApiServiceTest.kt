package com.linktic.janes.apiProductInventoriesLinktic.data.serviceApi

import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.UsersResponse
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


class UsersApiServiceTest {
    private val myWebClient = mockk<WebClient>()
    private val usersApi = UsersApiService(myWebClient)

    private val user = UsersResponse(
        1,
        "Janes",
        "12312312.00",
        "janes_saenz@hotmail.com"
    )
    val token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5lc19zYWVuekBob3RtYWlsLmNvbSIsImV4cCI6MTc2NTA1OTYyMX0.B6rjmgB-6q4jzT9jenhIJ4oPR3ZT1h3ALoThR9gQFeSwSjygYjwETbXjNQpxOR0k7oUIldQK3kUuwMu7V06U7Q"

    @Test
    fun `findAll returns correct List UsersResponse`() {
        // Configure the mock behavior for webClient.get()
        every { myWebClient.get() } returns mockk<WebClient.RequestHeadersUriSpec<*>>().apply {
            every { uri("/api/v1/users/email/{id}") } returns mockk<WebClient.RequestHeadersSpec<*>>().apply {
                every { retrieve() } returns mockk<WebClient.ResponseSpec>().apply {
                    every { bodyToMono(UsersResponse::class.java) } returns Mono.just(user)
                }
            }
        }
    }
}