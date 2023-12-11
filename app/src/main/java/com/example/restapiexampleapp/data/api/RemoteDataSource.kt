package com.example.restapiexampleapp.data.api

import com.example.restapiexampleapp.data.api.models.ResponseModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val service: Service
) {

    suspend fun getAllPosts() = service.getAllPosts()
    suspend fun postPosts(body: ResponseModel) = service.postPosts(body)
    suspend fun putPosts(id: Int, body: ResponseModel) = service.putPosts(id, body)
    suspend fun patchPosts(id: Int, body: ResponseModel) = service.patchPosts(id, body)
    suspend fun deletePosts(id: Int) = service.deletePosts(id)

}