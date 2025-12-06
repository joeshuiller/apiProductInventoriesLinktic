package com.linktic.janes.apiProductInventoriesLinktic.presentation.exception

import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.AccessDenied
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.InventoryNotExit
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.JwtExpired
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.ProductNotExit
import com.linktic.janes.apiProductsLinktic.domain.exception.InvalidJwtToken
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHadler {
    private val logger = LoggerFactory.getLogger(RestExceptionHadler::class.java)
    // Generic handler for all other RuntimeExceptions
    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException): ResponseEntity<Error> {
        // Log the exception details
        val errorResponse = Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error Generics", ex.message.toString())
        logger.error( "Error Generics : {}" , errorResponse)
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    // Generic handler for all other RuntimeExceptions
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<Error> {
        // Log the exception details
        val errorResponse = Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error General", ex.message.toString())
        logger.error( "Error General : {}" , errorResponse)
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(InvalidJwtToken::class)
    fun handleInvalidJwt(ex: InvalidJwtToken): ResponseEntity<Error>  {
        val errorResponse =
            Error(HttpStatus.UNAUTHORIZED.value(), "Error token invalido", ex.message.toString())
        logger.error("Error token invalido : {}", errorResponse)
        return ResponseEntity(errorResponse, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(JwtExpired::class)
    fun handleJwtExpired(ex: JwtExpired): ResponseEntity<Error>  {
        val errorResponse =
            Error(HttpStatus.UNAUTHORIZED.value(), "Error token expiro", ex.message.toString())
        logger.error("Error token expiro : {}", errorResponse)
        return ResponseEntity(errorResponse, HttpStatus.UNAUTHORIZED)
    }

    // Manejar otras excepciones como falta de rol (403)
    @ExceptionHandler(AccessDenied::class) // O tu excepción de falta de rol
    fun handleAccessDenied(ex: AccessDenied): ResponseEntity<Error>  {
        val errorResponse =
            Error(HttpStatus.FORBIDDEN.value(), "Error token", ex.message.toString())
        logger.error("Error token : {}", errorResponse)
        return ResponseEntity(errorResponse, HttpStatus.FORBIDDEN)
    }

    // Generic handler for all other RuntimeExceptions
    @ExceptionHandler(ProductNotExit::class)
    fun handleProductNotExit(ex: ProductNotExit): ResponseEntity<Error> {
        // Log the exception details
        val errorResponse = Error(HttpStatus.UNAUTHORIZED.value(), "Error producto no existe",ex.message.toString())
        logger.error( "Error producto no existe : {}" , errorResponse)
        return ResponseEntity(errorResponse, HttpStatus.UNAUTHORIZED)
    }

    // Generic handler for all other RuntimeExceptions
    @ExceptionHandler(InventoryNotExit::class)
    fun handleInventoryNotExit(ex: InventoryNotExit): ResponseEntity<Error> {
        // Log the exception details
        val errorResponse = Error(HttpStatus.UNAUTHORIZED.value(), "Error inventario no existe",ex.message.toString())
        logger.error( "Error inventario no existe : {}" , errorResponse)
        return ResponseEntity(errorResponse, HttpStatus.UNAUTHORIZED)
    }


}