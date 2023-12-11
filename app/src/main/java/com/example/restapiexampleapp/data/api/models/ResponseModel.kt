package com.example.restapiexampleapp.data.api.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("body") val body: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("userId") val userId: Int? = null
)