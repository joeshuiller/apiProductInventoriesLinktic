package com.linktic.janes.apiProductInventoriesLinktic.configuration

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class JwtServiceTest {
    private var secret: String = "3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b"
    private var expiration: Long = 86400000
    private var email: String = "janes_saenz@hotmail.com"
    private val jwtService = JwtService()
    val token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5lc19zYWVuekBob3RtYWlsLmNvbSIsImV4cCI6MTc2NTA3OTAxMH0.8LT4OPKwxgCEbi1gWMHQ51WtBMlnjPOKIFsCd3iHf6qbCZyk3cYpaMil5HPJBgJM4-Fbq1tnIAqp1P3fn_VPwg"


    @Test
    fun `Email  returns correct`() {
        //every { jwtService.getEmail(token)} returns email
        val data = jwtService.getEmail(token)
        assertEquals(data, email)
    }

    @Test
    fun `is Token Valid  returns correct`() {
        val data = jwtService.isTokenValid(token)
        assertTrue(data)
    }

}