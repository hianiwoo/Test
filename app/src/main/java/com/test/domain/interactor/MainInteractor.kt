package com.test.domain.interactor

import com.test.data.api.ApiService
import javax.inject.Inject

class MainInteractor @Inject constructor(private val apiService: ApiService) {

    suspend fun getLast(page: Int, quantity: Int) =
        apiService.getAnime(page = page, quantity = quantity).data
}