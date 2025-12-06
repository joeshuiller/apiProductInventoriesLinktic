package com.linktic.janes.apiProductInventoriesLinktic.domain.service

import com.linktic.janes.apiProductInventoriesLinktic.configuration.JwtService
import com.linktic.janes.apiProductInventoriesLinktic.data.entity.InventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.serviceApi.UsersApiService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.ProductsResponse
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class UsefulValidServiceTest {
    private  val  usersApi = mockk<UsersApiService>()
    private  val  jwtService = mockk<JwtService>()
    private  val  productApi = mockk<UsersApiService>()
    private val userService = UsefulValidService(
        jwtService,
        usersApi,
        productApi
    )
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
    val products = ProductsResponse(
        778878,
        "7",
        "7".toBigDecimal(),
        "hola"
    )
    private val arrayUsers = listOf(inventory)

    val userEntity = InventoryEntity(
        1,
        45,
        3,
        3
    )
    val token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5lc19zYWVuekBob3RtYWlsLmNvbSIsImV4cCI6MTc2NDk1MTA0M30.-3wjztXt2of_9a1uEV-aeJZSDmuyJSgNbnXETBN_tNIgYZCbCsowChUkc3MLYEJQ_rTy066Qd8_8n-Vo5UU85A"

    @Test
    fun `load User By Username returns correct`(){
        every { userService.valiToken(token)} returns true
    }

    @Test
    fun `mapper Inventory returns correct`(){
        every { productApi.fetchDataProduct("1", token)} returns products
        every { userService.mapperInventory(userAuth, token)} returns userAuth
    }

    @Test
    fun `mapper Purchase History returns correct`(){
        every { productApi.fetchDataProduct("1", token)} returns products
        every { userService.mapperPurchaseHistory(purchase, token)} returns purchase
    }
}