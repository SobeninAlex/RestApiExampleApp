package com.example.restapiexampleapp.domain.usecases

import com.example.restapiexampleapp.data.Repository
import com.example.restapiexampleapp.data.api.models.ResponseModel
import javax.inject.Inject

class PostPostUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun execute(body: ResponseModel) =
        repository.postPosts(body)

}