package com.linktic.janes.apiProductInventoriesLinktic.domain.service

import com.linktic.janes.apiProductInventoriesLinktic.configuration.JwtService
import com.linktic.janes.apiProductInventoriesLinktic.data.serviceApi.UsersApiService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.JwtExpired
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.ProductNotExit
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.jvm.java

@Service
class UsefulValidService(
    private val jwtService: JwtService,
    private val apiRestService: UsersApiService,
    private val productApi: UsersApiService
) {
    private val logger = LoggerFactory.getLogger(UsefulValidService::class.java)
    fun mapperInventory(request: InventoryRequest, token: String): InventoryRequest?{
        val email = jwtService.getEmail(token)
        val data = apiRestService.fetchDataUsers(email, token)
        val idProduct = productApi.fetchDataProduct(request.idProduct.toString(), token)
        logger.error( "Error producto : {}" , idProduct)
        if (idProduct == null) throw ProductNotExit("Producto no encontrado")
        val product = InventoryRequest(
            request.amount,
            idProduct.id ?: request.idProduct,
            data?.id
        )
        return product
    }

    fun mapperPurchaseHistory(request: PurchaseHistoryRequest, token: String): PurchaseHistoryRequest?{
        val email = jwtService.getEmail(token)
        val data = apiRestService.fetchDataUsers(email, token)
        val idProduct = productApi.fetchDataUsers(request.idProduct.toString(), token)
        if (idProduct == null) throw ProductNotExit("Producto no encontrado")
        val product = PurchaseHistoryRequest(
            request.amount,
            request.idInventory,
            idProduct.id ?: request.idInventory,
            data?.id
        )
        return product
    }

    @Throws(JwtExpired::class)
    fun valiToken(token: String): Boolean{
        val data = jwtService.isTokenValid(token)
        if (!data) throw JwtExpired("Token expiró")
        return jwtService.isTokenValid(token)
    }
}