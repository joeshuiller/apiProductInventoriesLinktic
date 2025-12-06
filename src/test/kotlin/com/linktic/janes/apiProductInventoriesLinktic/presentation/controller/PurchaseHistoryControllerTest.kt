package com.linktic.janes.apiProductInventoriesLinktic.presentation.controller

import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.PurchaseHistoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.service.PurchaseHistoryService
import com.linktic.janes.apiProductInventoriesLinktic.domain.service.UsefulValidService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class PurchaseHistoryControllerTest {
    private val authService = mockk<PurchaseHistoryService>()
    private val usefulValidService = mockk<UsefulValidService>()
    private val auth = PurchaseHistoryController(authService, usefulValidService)
    private val inventory = PurchaseHistoryResponse(
        1,
        "Janes",
        "0.0000".toBigDecimal(),
        "",
        0,
        0
    )
    val userAuth = PurchaseHistoryRequest(
        778878,
        7,
        7
    )
    val purchase = PurchaseHistoryRequest(
        778878,
        7,
        7
    )
    private val arrayUsers = listOf(inventory)
    val token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5lc19zYWVuekBob3RtYWlsLmNvbSIsImV4cCI6MTc2NTA1OTYyMX0.B6rjmgB-6q4jzT9jenhIJ4oPR3ZT1h3ALoThR9gQFeSwSjygYjwETbXjNQpxOR0k7oUIldQK3kUuwMu7V06U7Q"

    @Test
    fun `get User All returns correct`(){
        every { usefulValidService.valiToken(token)} returns true
        every { authService.findAll()} returns arrayUsers
        val expectedResponse: ResponseEntity<List<PurchaseHistoryResponse?>> = ResponseEntity.ok(arrayUsers)
        every { auth.getUserAll(token) } returns expectedResponse
    }

    @Test
    fun `get User By Id returns correct`(){
        every { usefulValidService.valiToken(token)} returns true
        every { authService.findAll() } returns arrayUsers
        val expectedResponse: ResponseEntity<PurchaseHistoryResponse> = ResponseEntity.ok(inventory)
        every { auth.getUserById(0, token) } returns expectedResponse
    }

    @Test
    fun `register returns correct`(){
        every { usefulValidService.valiToken(token)} returns true
        every { authService.save(userAuth, token) } returns inventory
        val expectedResponse: ResponseEntity<PurchaseHistoryResponse> = ResponseEntity.ok(inventory)
        every { auth.register(userAuth, token) } returns expectedResponse
    }
}