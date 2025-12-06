package com.linktic.janes.apiProductInventoriesLinktic.data.serviceApi

import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.ProductsResponse
import com.linktic.janes.apiProductInventoriesLinktic.domain.dto.response.UsersResponse
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import reactor.util.retry.Retry
import java.time.Duration
import kotlin.jvm.java

@Service
class UsersApiService(
    private val myWebClient: WebClient
) {
    fun fetchDataUsers(resourceId: String, token: String): UsersResponse? {
        return myWebClient.get()
            .uri("http://localhost:8090/api/v1/users/email/{id}", resourceId)
            .header(HttpHeaders.AUTHORIZATION, token)// Path relative to base URL
            .retrieve()
            .bodyToMono(UsersResponse::class.java)
            .retryWhen(
                Retry.backoff(3, Duration.ofSeconds(1)) // 3 reintentos, con espera exponencial inicial
                    .maxBackoff(Duration.ofSeconds(5)) // Máximo 5 segundos de espera
                    .filter { it is WebClientResponseException && it.statusCode.is5xxServerError } // Solo reintentar errores 5xx
            )
            .block()// Convert Mono to a suspend function result
    }

    fun fetchDataProduct(resourceId: String, token: String): ProductsResponse? {
        return myWebClient.get()
            .uri("http://localhost:8091/api/v1/products/{id}", resourceId)
            .header(HttpHeaders.AUTHORIZATION, token)// Path relative to base URL
            .retrieve()
            .bodyToMono(ProductsResponse::class.java)
            .retryWhen(
                Retry.backoff(3, Duration.ofSeconds(1)) // 3 reintentos, con espera exponencial inicial
                    .maxBackoff(Duration.ofSeconds(5)) // Máximo 5 segundos de espera
                    .filter { it is WebClientResponseException && it.statusCode.is5xxServerError } // Solo reintentar errores 5xx
            )
            .block()// Convert Mono to a suspend function result
    }
}