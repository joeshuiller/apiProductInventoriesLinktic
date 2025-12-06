package com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request

import jakarta.validation.constraints.NotNull


data class InventoryRequest(
    @NotNull
    val amount: Long,
    @NotNull
    val idProduct: Long,
    val idUsers: Long? = null
)
