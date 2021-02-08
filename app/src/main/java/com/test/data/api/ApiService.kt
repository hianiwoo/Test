package com.test.data.api

import com.test.domain.models.BaseResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService {
    @GET("last")
    suspend fun getAnime(
        @Query("page") page: Int,
        @Query("quantity") quantity: Int
    ): BaseResponce
}