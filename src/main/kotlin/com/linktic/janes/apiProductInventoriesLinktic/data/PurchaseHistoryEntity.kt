package com.linktic.janes.apiProductInventoriesLinktic.data

import com.linktic.janes.apiProductInventoriesLinktic.data.crud.CrudPurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.entity.PurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.mapper.PurchaseHistoryMapperService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.PurchaseHistoryRepository

class PurchaseHistoryEntity(
    private val mapper: PurchaseHistoryMapperService,
    private val crudInventory: CrudPurchaseHistoryEntity,
): PurchaseHistoryRepository {
    override fun findAll(): List<PurchaseHistoryEntity?> {
        return crudInventory.findAll()
    }

    override fun finById(id: Long): PurchaseHistoryEntity {
        val data = crudInventory.findById(id).orElseThrow()
        return data
    }

    override fun save(purchase: PurchaseHistoryRequest): PurchaseHistoryEntity? {
        return crudInventory.save(mapper.toEntity(purchase))
    }

    override fun updateById(
        id: Long,
        purchase: PurchaseHistoryRequest
    ): PurchaseHistoryEntity? {
        val data = crudInventory.findById(id).orElseThrow()
        data.amount = purchase.amount
        return data
    }

}