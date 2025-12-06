package com.linktic.janes.apiProductInventoriesLinktic.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class InventoryNotExit(message: String) : RuntimeException(message){
}