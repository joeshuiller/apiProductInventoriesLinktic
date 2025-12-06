package com.linktic.janes.apiProductInventoriesLinktic.presentation.controller

import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.ProductsResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.service.InventoryService
import com.linktic.janes.apiProductInventoriesLinktic.domain.service.UsefulValidService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.servlet.mvc.Controller

@ExtendWith(SpringExtension::class)
@WebMvcTest(Controller::class)
class InventoryControllerTest {
    val email = "janes_saenz@hotmail.com"
    private val inventory = InventoryResponse(
        1,
        2,
        "Janes",
        "0.0000".toBigDecimal(),
        "prueba"
    )
    val userAuth = InventoryRequest(
        778878,
        7,
        7
    )
    val token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5lc19zYWVuekBob3RtYWlsLmNvbSIsImV4cCI6MTc2NTA1OTYyMX0.B6rjmgB-6q4jzT9jenhIJ4oPR3ZT1h3ALoThR9gQFeSwSjygYjwETbXjNQpxOR0k7oUIldQK3kUuwMu7V06U7Q"
    private val arrayUsers = listOf(inventory)
    private val authService = mockk<InventoryService>()
    private val usefulValidService = mockk<UsefulValidService>()
    private val auth = InventoryController(authService, usefulValidService)

    @Test
    fun `get User All returns correct`(){
        every { usefulValidService.valiToken(token)} returns true
        every { authService.findAll()} returns arrayUsers
        val expectedResponse: ResponseEntity<List<InventoryResponse?>> = ResponseEntity.ok(arrayUsers)
        every { auth.getUserAll(token) } returns expectedResponse
    }

    @Test
    fun `get User By Id returns correct`(){
        every { usefulValidService.valiToken(token)} returns true
        every { authService.findAll() } returns arrayUsers
        val expectedResponse: ResponseEntity<InventoryResponse> = ResponseEntity.ok(inventory)
        every { auth.getUserById(0, token) } returns expectedResponse
    }

    @Test
    fun `register returns correct`(){
        every { usefulValidService.valiToken(token)} returns true
        every { authService.save(userAuth, token) } returns inventory
        val expectedResponse: ResponseEntity<InventoryResponse> = ResponseEntity.ok(inventory)
        every { auth.register(userAuth, token) } returns expectedResponse
    }
}