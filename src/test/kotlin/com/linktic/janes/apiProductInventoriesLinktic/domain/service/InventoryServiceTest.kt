package com.linktic.janes.apiProductInventoriesLinktic.domain.service

import com.linktic.janes.apiProductInventoriesLinktic.data.serviceApi.UsersApiService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.InventoryRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class InventoryServiceTest {
    private val authRepository = mockk<InventoryRepository>()
    private val apiRestService = mockk<UsersApiService>()
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
    val purchase = PurchaseHistoryRequest(
        778878,
        7,
        7
    )
    private val arrayUsers = listOf(inventory)
    private val userService = InventoryService(
        authRepository,
        apiRestService
    )

    val token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5lc19zYWVuekBob3RtYWlsLmNvbSIsImV4cCI6MTc2NDk1MTA0M30.-3wjztXt2of_9a1uEV-aeJZSDmuyJSgNbnXETBN_tNIgYZCbCsowChUkc3MLYEJQ_rTy066Qd8_8n-Vo5UU85A"

    @Test
    fun `findAll returns correct List UsersResponse`() {
        every { userService.findAll()} returns arrayUsers
    }

    @Test
    fun `finById returns correct UsersResponse`() {
        every { userService.finById(0, token)} returns inventory
    }

    @Test
    fun `signup returns correct UsersResponse`() {
        every { userService.save(userAuth, token)} returns inventory
    }

}