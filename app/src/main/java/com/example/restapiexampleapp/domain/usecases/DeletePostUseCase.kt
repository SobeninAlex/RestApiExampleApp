package com.example.restapiexampleapp.domain.usecases

import com.example.restapiexampleapp.data.Repository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun execute(id: Int) =
        repository.deletePosts(id)

}