package com.linktic.janes.apiProductInventoriesLinktic.data.crud

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.InventoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CrudInventoryEntity:  JpaRepository<InventoryEntity, Long> {
}