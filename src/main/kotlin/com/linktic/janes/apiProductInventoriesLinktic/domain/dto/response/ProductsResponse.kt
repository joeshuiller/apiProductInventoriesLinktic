package com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response

import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductsResponse(
    val id: Long? = null,
    val name: String,
    val price: BigDecimal,
    val description: String,
    var createAt: LocalDateTime? = null,
    var updateAt: LocalDateTime? = null
)