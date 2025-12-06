package com.linktic.janes.apiProductInventoriesLinktic.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class JwtExpired(message: String) : RuntimeException(message){
}