package com.linktic.janes.apiProductInventoriesLinktic.data.mapper


import com.linktic.janes.apiProductInventoriesLinktic.data.entity.InventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InventoryMapperServiceTest {
    val userEntity = InventoryEntity(
        1,
        1,
        1,
        1
    )
    val userAuth = InventoryRequest(
        778878,
        1,
        7
    )
    private val usersMapperService = InventoryMapperService()

    @Test
    fun `from Entity returns correct`() {
        val data = usersMapperService.fromEntity(userEntity)
        assertEquals(data.id, userAuth.idProduct)
    }

    @Test
    fun `to Entity returns correct`() {
        val data = usersMapperService.toEntity(userAuth)
        val expected = userEntity.idProduct
        assertEquals(data.idProduct, expected)
    }
}