package com.linktic.janes.apiProductInventoriesLinktic.data

import com.linktic.janes.apiProductInventoriesLinktic.data.crud.CrudInventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.entity.InventoryEntity
import com.linktic.janes.apiProductInventoriesLinktic.data.mapper.InventoryMapperService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.InventoryRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class InventoryEntityRepository(
    private val mapper: InventoryMapperService,
    private val crudInventory: CrudInventoryEntity,
): InventoryRepository {
    override fun findAll(): List<InventoryEntity?> {
        return crudInventory.findAll()
    }

    override fun finById(id: Long): InventoryEntity? {
        val data = crudInventory.findById(id).orElseThrow()
        return data
    }
    @Transactional
    override fun save(inventory: InventoryRequest): InventoryEntity? {
        return crudInventory.save(mapper.toEntity(inventory))
    }

    @Transactional
    override fun updateById(
        id: Long,
        inventory: InventoryRequest
    ): InventoryEntity? {
        val data = crudInventory.findById(id).orElseThrow()
        data.amount = inventory.amount
        return data
    }

}