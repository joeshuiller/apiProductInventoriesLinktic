package com.linktic.janes.apiProductInventoriesLinktic.domain.repository

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.InventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse

interface InventoryRepository {
    fun findAll(): List<InventoryEntity?>
    fun finById(id: Long): InventoryEntity?
    fun save(inventory: InventoryRequest): InventoryEntity?
    fun updateById(id: Long, inventory: InventoryRequest): InventoryEntity?
}