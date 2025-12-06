package com.linktic.janes.apiProductInventoriesLinktic.data.mapper

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.PurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.PurchaseHistoryResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PurchaseHistoryMapperServiceTest {
    val userEntity = PurchaseHistoryEntity(
        1,
        1,
        1,
        1
    )
    val userAuth = PurchaseHistoryResponse(
        1,
        "Janes",
        "12312312.00".toBigDecimal(),
        "janes_saenz@hotmail.com",
        1,
        1
    )
    val userRequest = PurchaseHistoryRequest(
        1,
        1,
        1,
        1
    )
    private val usersMapperService = PurchaseHistoryMapperService()

    @Test
    fun `from Entity returns correct`() {
        val data = usersMapperService.fromEntity(userEntity)
        assertEquals(data.name, userAuth.name)
    }

    @Test
    fun `to Entity returns correct`() {
        val data = usersMapperService.toEntity(userRequest)
        val expected = userEntity.amount
        assertEquals(data.amount, expected)
    }
}