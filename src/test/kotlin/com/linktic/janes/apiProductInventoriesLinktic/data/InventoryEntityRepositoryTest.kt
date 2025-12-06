package com.linktic.janes.apiProductInventoriesLinktic.data

import com.linktic.janes.apiProductInventoriesLinktic.data.crud.CrudInventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.entity.InventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.mapper.InventoryMapperService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class InventoryEntityRepositoryTest {
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
    val inventoryList = InventoryEntity(
        1,
        1,
        1,
        1
    )
    private val arrayUsers = listOf(inventoryList)

    private val usersMapper = mockk<InventoryMapperService>()
    private val crudAuthEntity = mockk<CrudInventoryEntity>()
    private val authEntityRepository = InventoryEntityRepository(
        usersMapper,
        crudAuthEntity
    )


    @Test
    fun `find All returns correct`() {
        every { authEntityRepository.findAll()} returns arrayUsers
    }

    @Test
    fun `fin By Id returns correct`() {
        every { authEntityRepository.finById(0)} returns inventoryList
    }


    @Test
    fun `save returns correct`() {
        every { authEntityRepository.save(userAuth)} returns inventoryList
    }

    @Test
    fun `update By Id returns correct`() {
        every { authEntityRepository.updateById(1,userAuth)} returns inventoryList
    }



}