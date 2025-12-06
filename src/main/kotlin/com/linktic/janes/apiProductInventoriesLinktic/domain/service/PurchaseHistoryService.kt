package com.linktic.janes.apiProductInventoriesLinktic.domain.service

import com.linktic.janes.apiProductInventoriesLinktic.data.serviceApi.UsersApiService
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.PurchaseHistoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.PurchaseHistoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.exception.ProductNotExit
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.InventoryRepository
import com.linktic.janes.apiProductInventoriesLinktic.domain.repository.PurchaseHistoryRepository
import com.linktic.janes.apiProductInventoriesLinktic.presentation.utils.UtilService

class PurchaseHistoryService(
    private val purchaseHistory: PurchaseHistoryRepository,
    private val productApi: UsersApiService,
    private val inventoryRepository: InventoryRepository,
) {
    private var utilService = UtilService()
    fun findAll(): List<PurchaseHistoryResponse?>{
        val result = purchaseHistory.findAll()
        val data = result.map {
                it ->
                 it?.let { it1 ->
                    PurchaseHistoryResponse(
                        it.id,
                        "",
                        "0.0".toBigDecimal(),
                        "",
                        it.amount,
                        0,
                        it.updateAt,
                        it.createAt
                    )
            }
        }
        return data
    }

    fun finById(id: Long, token:String): PurchaseHistoryResponse?{
        val idProduct = productApi.fetchDataProduct(id.toString(), token)
        if (idProduct == null) throw ProductNotExit("Producto no encontrado")
        val result =  purchaseHistory.finById(id)
        val resultList =  inventoryRepository.finById(id)
        val lis = utilService.mapperResponse(resultList, idProduct)
        return lis?.let { utilService.mapperToResponse(result, it) }
    }

    fun save(products: PurchaseHistoryRequest, token:String): PurchaseHistoryResponse?{
        val idProduct = productApi.fetchDataProduct(products.idProduct.toString(), token)
        if (idProduct == null) throw ProductNotExit("Producto no encontrado")
        val result =  purchaseHistory.save(products)
        val resultList = result?.id?.let { inventoryRepository.finById(it) }
        val lis = utilService.mapperResponse(resultList, idProduct)
        return lis?.let { utilService.mapperToResponse(result, it) }
    }
}