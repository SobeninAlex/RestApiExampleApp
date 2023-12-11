package com.example.restapiexampleapp.domain.usecases

import com.example.restapiexampleapp.data.Repository
import com.example.restapiexampleapp.data.api.models.ResponseModel
import javax.inject.Inject

class PutPostUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun execute(id: Int, body: ResponseModel) =
        repository.putPosts(id, body)

}