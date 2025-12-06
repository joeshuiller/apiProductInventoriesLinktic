package com.linktic.janes.apiProductInventoriesLinktic.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Table(name = "purchase_history")
@Entity
data class PurchaseHistoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "amount", nullable = false)
    var amount: Long,
    @Column(name = "id_inventory", nullable = false)
    var idInventory: Long,
    @Column(name = "id_users", nullable = false)
    val idUsers: Long?,
    @CreationTimestamp
    @Column(name = "create_at",nullable = true)
    val createAt: LocalDateTime? = null,
    @UpdateTimestamp
    @Column(name = "update_at",nullable = true)
    val updateAt: LocalDateTime? = null
)
