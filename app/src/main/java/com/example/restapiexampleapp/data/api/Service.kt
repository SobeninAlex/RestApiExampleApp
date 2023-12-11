package com.example.restapiexampleapp.data.api

import com.example.restapiexampleapp.data.api.models.ResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface Service {

    @GET("/posts")
    suspend fun getAllPosts(): Response<List<ResponseModel>>

    @POST("/posts")
    suspend fun postPosts(@Body body: ResponseModel): Response<ResponseModel>

    @PUT("/posts/{id}")
    suspend fun putPosts(
        @Path("id") id: Int,
        @Body body: ResponseModel
    ): Response<ResponseModel>

    @PATCH("/posts/{id}")
    suspend fun patchPosts(
        @Path("id") id: Int,
        @Body body: ResponseModel
    ): Response<ResponseModel>

    @DELETE("/posts/{id}")
    suspend fun deletePosts(@Path("id") id: Int): Response<ResponseModel>

}