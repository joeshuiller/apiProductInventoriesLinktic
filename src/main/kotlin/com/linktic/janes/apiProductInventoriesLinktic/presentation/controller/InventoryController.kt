package com.linktic.janes.apiProductInventoriesLinktic.presentation.controller

import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.request.InventoryRequest
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.InventoryResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.service.InventoryService
import com.linktic.janes.apiProductInventoriesLinktic.domain.service.UsefulValidService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/inventory/")
class InventoryController(
    private val inventoryService: InventoryService,
    private val usefulValidService: UsefulValidService
) {
    private val logger = LoggerFactory.getLogger(InventoryController::class.java)
    var token = true
    @GetMapping("/all")
    fun getUserAll(
        @RequestHeader("Authorization") authorizationHeader: String
    ): ResponseEntity<List<InventoryResponse?>> {
        token = usefulValidService.valiToken(authorizationHeader)
        val user = inventoryService.findAll()
        return ResponseEntity.ok(user)
    }

    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorizationHeader: String
    ): ResponseEntity<InventoryResponse> {
        token = usefulValidService.valiToken(authorizationHeader)
        val user = inventoryService.finById(id, authorizationHeader)
        return ResponseEntity.ok(user)
    }

    @PostMapping("/register")
    fun register(
        @RequestBody @Valid request: InventoryRequest,
        @RequestHeader("Authorization") authorizationHeader: String): ResponseEntity<InventoryResponse> {
        token = usefulValidService.valiToken(authorizationHeader)
        val usefulValid = usefulValidService.mapperInventory(request, authorizationHeader)
        logger.error( "Error producto no existe : {}" , usefulValid)
        val users = usefulValid?.let { inventoryService.save(it, authorizationHeader) }
        return ResponseEntity.ok(users)
    }

    @PostMapping("/{id}")
    fun putSave(
        @PathVariable id: Long,
        @RequestBody @Valid request: InventoryRequest,
        @RequestHeader("Authorization") authorizationHeader: String): ResponseEntity<InventoryResponse> {
        token = usefulValidService.valiToken(authorizationHeader)
        val usefulValid = usefulValidService.mapperInventory(request, authorizationHeader)
        val users = usefulValid?.let { inventoryService.putSave(id,it, authorizationHeader) }
        return ResponseEntity.ok(users)
    }
}