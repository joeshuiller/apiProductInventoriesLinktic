package com.linktic.janes.apiProductInventoriesLinktic.data.mapper

interface Mapper<D, E, B> {
    fun fromEntity(entity: E): B
    fun toEntity(domain: D): E
}