package com.linktic.janes.apiProductInventoriesLinktic.domain.repository

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.PurchaseHistoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest

interface PurchaseHistoryRepository {
    fun findAll(): List<PurchaseHistoryEntity?>
    fun finById(id: Long): PurchaseHistoryEntity?
    fun save(purchase: PurchaseHistoryRequest): PurchaseHistoryEntity?
    fun updateById(id: Long, purchase: PurchaseHistoryRequest): PurchaseHistoryEntity?
}