package com.linktic.janes.apiProductInventoriesLinktic.data.mapper

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.PurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.PurchaseHistoryResponse

class PurchaseHistoryMapperService: Mapper<PurchaseHistoryRequest, PurchaseHistoryEntity, PurchaseHistoryResponse> {
    override fun fromEntity(entity: PurchaseHistoryEntity): PurchaseHistoryResponse {
        TODO("Not yet implemented")
    }

    override fun toEntity(domain: PurchaseHistoryRequest): PurchaseHistoryEntity {
        TODO("Not yet implemented")
    }

}