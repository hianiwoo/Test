package com.test.domain.models

import com.google.gson.annotations.SerializedName

data class BaseResponce(
    @SerializedName("data") val data: List<Anime>
)