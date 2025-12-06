package com.linktic.janes.apiProductInventoriesLinktic.domain.service

import com.linktic.janes.apiProductInventoriesLinktic.data.serviceApi.UsersApiService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.ProductNotExit
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.InventoryRepository
import com.linktic.janes.apiProductInventoriesLinktic.presentation.utils.UtilService
import org.springframework.stereotype.Service

@Service
class InventoryService(
    private val inventoryRepository: InventoryRepository,
    private val productApi: UsersApiService
) {
    private var utilService = UtilService()
    fun findAll(): List<InventoryResponse?>{
        val result = inventoryRepository.findAll()
        val data = result.map {
                it ->
                    it?.amount?.let { amount ->
                        InventoryResponse(
                            it.id,
                            amount,
                           "",
                            "0.0".toBigDecimal(),
                            "",
                            it.createAt,
                            it.updateAt,
                        )
            }
        }
        return data
    }

    fun finById(id: Long, token:String): InventoryResponse?{
        val idProduct = productApi.fetchDataProduct(id.toString(), token)
        if (idProduct == null) throw ProductNotExit("Producto no encontrado")
        val result =  inventoryRepository.finById(id)
        return utilService.mapperResponse(result, idProduct)
    }

    fun save(products: InventoryRequest, token:String): InventoryResponse?{
        val idProduct = productApi.fetchDataProduct(products.idProduct.toString(), token)
        if (idProduct == null) throw ProductNotExit("Producto no encontrado")
        val result =  inventoryRepository.save(products)
        return utilService.mapperResponse(result, idProduct)
    }
}