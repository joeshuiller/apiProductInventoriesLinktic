package com.linktic.janes.apiProductInventoriesLinktic.presentation.utils

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.InventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.entity.PurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.ProductsResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.PurchaseHistoryResponse

class UtilService {
    fun mapperResponse(
        t: InventoryEntity?,
        r: ProductsResponse
    ): InventoryResponse? {
        return t?.amount?.let {
            InventoryResponse(
                t.id,
                it,
                r.name,
                r.price,
                r.description,
                t.createAt,
                t.updateAt,
            )
        }
    }

    fun mapperToResponse(
        t: PurchaseHistoryEntity?,
        r: InventoryResponse
    ): PurchaseHistoryResponse {
        return PurchaseHistoryResponse(
            t?.id,
            r.name,
            r.price,
            r.description,
            t?.amount ?: 0,
            r.amount,
            t?.createAt,
            t?.updateAt
        )
    }
}