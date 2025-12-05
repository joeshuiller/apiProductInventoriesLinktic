package com.linktic.janes.apiProductsLinktic.configuration

import io.jsonwebtoken.Jwts
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import kotlin.text.toByteArray


@Service
class JwtService {
    private val logger = LoggerFactory.getLogger(JwtService::class.java)
    private var secret: String = "3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b"

    private fun getClaims(token: String) =
        Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(token).body

    fun getEmail(token: String): String {
        val tokenList = token.substring(7)
        return getClaims(tokenList.trim()).subject
    }

    fun isTokenValid(token: String): Boolean {
        val tokenList = token.substring(7)
        val claims = getClaims(tokenList.trim())
        val expirationDate = claims.expiration
        val now = Date(System.currentTimeMillis())
        return now.before(expirationDate)
    }
}