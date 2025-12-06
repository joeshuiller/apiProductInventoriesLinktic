package com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request

import jakarta.validation.constraints.NotNull

data class PurchaseHistoryRequest(
    @NotNull
    val amount: Long,
    @NotNull
    val idInventory: Long,
    val idProduct: Long? = null,
    val idUsers: Long? = null
)