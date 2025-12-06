package com.linktic.janes.apiProductInventoriesLinktic.data.mapper

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.InventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import org.springframework.stereotype.Service

@Service
class InventoryMapperService: Mapper<InventoryRequest, InventoryEntity, InventoryResponse> {
    override fun fromEntity(entity: InventoryEntity): InventoryResponse {
        return InventoryResponse(
            entity.id,
            entity.amount ?: 0,
            "",
            "0.0".toBigDecimal(),
            "",
            entity.createAt,
            entity.updateAt
        )
    }

    override fun toEntity(domain: InventoryRequest): InventoryEntity {
        return InventoryEntity(
            null,
            domain.amount,
            domain.idProduct,
            domain.idUsers
        )
    }

}