package com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response

import java.time.LocalDateTime

data class UsersResponse(
    val id: Long?,
    val name: String,
    val surName: String,
    val email: String,
    val createAt: LocalDateTime? = null,
    val updateAt: LocalDateTime? = null,
)