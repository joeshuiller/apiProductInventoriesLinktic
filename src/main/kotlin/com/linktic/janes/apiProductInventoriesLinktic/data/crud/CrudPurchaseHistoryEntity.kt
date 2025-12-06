package com.linktic.janes.apiProductInventoriesLinktic.data.crud

import com.linktic.janes.apiProductInventoriesLinktic.data.entity.PurchaseHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CrudPurchaseHistoryEntity:  JpaRepository<PurchaseHistoryEntity, Long> {
}