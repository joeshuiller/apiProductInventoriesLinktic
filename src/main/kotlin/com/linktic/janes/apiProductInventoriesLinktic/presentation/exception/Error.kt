package com.linktic.janes.apiProductInventoriesLinktic.presentation.exception

data class Error(
    val status: Int,
    val type: String,
    val message: String
)
