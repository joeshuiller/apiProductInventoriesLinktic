package com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response

import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDateTime

data class PurchaseHistoryResponse(
    val id: Long? = null,
    val name: String,
    val price: BigDecimal,
    val description: String,
    val amount: Long,
    val availableQuantity: Long,
    var createAt: LocalDateTime? = null,
    var updateAt: LocalDateTime? = null
)
