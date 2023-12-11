package com.example.restapiexampleapp.data

import com.example.restapiexampleapp.data.api.RemoteDataSource
import com.example.restapiexampleapp.data.api.models.ResponseModel
import com.example.restapiexampleapp.utils.ApiResponse
import com.example.restapiexampleapp.utils.NetworkResult
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): ApiResponse() {

    suspend fun getAllPosts(): NetworkResult<List<ResponseModel>> {
        return safeApiCall { remoteDataSource.getAllPosts() }
    }

    suspend fun postPosts(body: ResponseModel): NetworkResult<ResponseModel> {
        return safeApiCall { remoteDataSource.postPosts(body) }
    }

    suspend fun putPosts(id: Int, body: ResponseModel): NetworkResult<ResponseModel> {
        return safeApiCall { remoteDataSource.putPosts(id, body) }
    }

    suspend fun patchPosts(id: Int, body: ResponseModel): NetworkResult<ResponseModel> {
        return safeApiCall { remoteDataSource.patchPosts(id, body) }
    }

    suspend fun deletePosts(id: Int): NetworkResult<ResponseModel> {
        return safeApiCall { remoteDataSource.deletePosts(id) }
    }

}