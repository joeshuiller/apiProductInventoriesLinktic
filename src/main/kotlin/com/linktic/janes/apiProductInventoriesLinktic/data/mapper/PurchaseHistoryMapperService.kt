package com.linktic.janes.apiProductInventoriesLinktic.data.mapper

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.PurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.PurchaseHistoryResponse

class PurchaseHistoryMapperService: Mapper<PurchaseHistoryRequest, PurchaseHistoryEntity, PurchaseHistoryResponse> {
    override fun fromEntity(entity: PurchaseHistoryEntity): PurchaseHistoryResponse {
        return  PurchaseHistoryResponse(
            entity.id,
            "Janes",
            "0.0".toBigDecimal(),
            "",
            entity.amount,
            entity.amount
        )
    }

    override fun toEntity(domain: PurchaseHistoryRequest): PurchaseHistoryEntity {
        return PurchaseHistoryEntity(
            null,
            domain.amount,
            domain.idInventory,
            domain.idUsers
        )
    }

}