package com.linktic.janes.apiProductInventoriesLinktic.domain.service

import com.linktic.janes.apiProductInventoriesLinktic.data.serviceApi.UsersApiService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.PurchaseHistoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.InventoryRepository
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.PurchaseHistoryRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class PurchaseHistoryServiceTest {
    private val authRepository = mockk<PurchaseHistoryRepository>()
    private val apiRestService = mockk<UsersApiService>()
    private val inventoryRepository = mockk<InventoryRepository>()
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
    private val userService = PurchaseHistoryService(
        authRepository,
        apiRestService,
        inventoryRepository
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