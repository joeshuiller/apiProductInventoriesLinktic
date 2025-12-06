package com.linktic.janes.apiProductInventoriesLinktic.presentation.exception


import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.AccessDenied
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.InventoryNotExit
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.JwtExpired
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.ProductNotExit
import com.linktic.janes.apiProductsLinktic.domain.exception.InvalidJwtToken
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.Controller
import kotlin.test.assertEquals

@ExtendWith(SpringExtension::class)
@WebMvcTest(Controller::class)
class RestExceptionHadlerTest {
    private val auth = RestExceptionHadler()

    @Test
    @ExceptionHandler(RuntimeException::class)
    fun `handle Runtime Exception returns correct`(){
        val ex = RuntimeException("")
        val errorResponse = Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error General",ex.message.toString())
        val data = auth.handleRuntimeException(ex)
        val status = data.body?.status
        assertEquals(status, errorResponse.status)
    }

    @Test
    @ExceptionHandler(RuntimeException::class)
    fun `handle Exception returns correct`(){
        val ex = RuntimeException("")
        val errorResponse = Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error Generics",ex.message.toString())
        val data = auth.handleException(ex)
        val status = data.body?.status
        assertEquals(status, errorResponse.status)
    }

    @Test
    @ExceptionHandler(RuntimeException::class)
    fun `Product Not Exit returns correct`(){
        val ex = ProductNotExit("")
        val errorResponse = Error(HttpStatus.UNAUTHORIZED.value(), "Error Generics",ex.message.toString())
        val data = auth.handleProductNotExit(ex)
        val status = data.body?.status
        assertEquals(status, errorResponse.status)
    }

    @Test
    @ExceptionHandler(RuntimeException::class)
    fun `Invalid Jwt Token returns correct`(){
        val ex = InvalidJwtToken("")
        val errorResponse = Error(HttpStatus.UNAUTHORIZED.value(), "Error Generics",ex.message.toString())
        val data = auth.handleInvalidJwt(ex)
        val status = data.body?.status
        assertEquals(status, errorResponse.status)
    }

    @Test
    @ExceptionHandler(RuntimeException::class)
    fun `Jwt Expired returns correct`(){
        val ex = JwtExpired("")
        val errorResponse = Error(HttpStatus.UNAUTHORIZED.value(), "Error Generics",ex.message.toString())
        val data = auth.handleJwtExpired(ex)
        val status = data.body?.status
        assertEquals(status, errorResponse.status)
    }

    @Test
    @ExceptionHandler(RuntimeException::class)
    fun `Access Denied Token returns correct`(){
        val ex = AccessDenied("")
        val errorResponse = Error(HttpStatus.FORBIDDEN.value(), "Error Generics",ex.message.toString())
        val data = auth.handleAccessDenied(ex)
        val status = data.body?.status
        assertEquals(status, errorResponse.status)
    }

    @Test
    @ExceptionHandler(RuntimeException::class)
    fun `Inventory Not Exit Token returns correct`(){
        val ex = InventoryNotExit("")
        val errorResponse = Error(HttpStatus.UNAUTHORIZED.value(), "Error data",ex.message.toString())
        val data = auth.handleInventoryNotExit(ex)
        val status = data.body?.status
        assertEquals(status, errorResponse.status)
    }

}