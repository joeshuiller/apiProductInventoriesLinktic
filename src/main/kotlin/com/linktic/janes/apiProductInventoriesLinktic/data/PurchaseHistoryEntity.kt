package com.linktic.janes.apiProductInventoriesLinktic.data

import com.linktic.janes.apiProductInventoriesLinktic.data.crud.CrudInventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.crud.CrudPurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.entity.PurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.mapper.PurchaseHistoryMapperService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.ProductNotExit
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.PurchaseHistoryRepository

class PurchaseHistoryEntity(
    private val mapper: PurchaseHistoryMapperService,
    private val crudPurchase: CrudPurchaseHistoryEntity,
    private val crudInventory: CrudInventoryEntity,
): PurchaseHistoryRepository {
    override fun findAll(): List<PurchaseHistoryEntity?> {
        return crudPurchase.findAll()
    }

    override fun finById(id: Long): PurchaseHistoryEntity {
        val data = crudPurchase.findById(id).orElseThrow()
        return data
    }

    override fun save(purchase: PurchaseHistoryRequest): PurchaseHistoryEntity {
        updateInventory(purchase)
        return crudPurchase.save(mapper.toEntity(purchase))
    }

    override fun updateById(
        id: Long,
        purchase: PurchaseHistoryRequest
    ): PurchaseHistoryEntity? {
        val data = crudPurchase.findById(id).orElseThrow()
        data.amount = purchase.amount
        return data
    }

    private fun updateInventory(purchase: PurchaseHistoryRequest){
        val data = crudInventory.findById(purchase.idInventory).orElseThrow()
        val validAmount = (data.amount?.minus(purchase.amount))
        if ((validAmount ?: -1L) < 0L) throw ProductNotExit("No Hay producto suficiente en el inventario")
        else data.amount = validAmount
    }

}