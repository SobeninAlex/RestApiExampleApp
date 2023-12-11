package com.example.restapiexampleapp.domain.usecases

import com.example.restapiexampleapp.data.Repository
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun execute() =
        repository.getAllPosts()

}