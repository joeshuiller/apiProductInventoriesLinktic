package com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response

import java.math.BigDecimal
import java.time.LocalDateTime

data class InventoryResponse(
    val id: Long? = null,
    val amount: Long,
    val name: String,
    val price: BigDecimal,
    val description: String,
    val createAt: LocalDateTime? = null,
    val updateAt: LocalDateTime? = null,
)
