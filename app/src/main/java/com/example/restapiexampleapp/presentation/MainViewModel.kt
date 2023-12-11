package com.example.restapiexampleapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapiexampleapp.data.Repository
import com.example.restapiexampleapp.data.api.models.ResponseModel
import com.example.restapiexampleapp.domain.usecases.DeletePostUseCase
import com.example.restapiexampleapp.domain.usecases.GetAllPostsUseCase
import com.example.restapiexampleapp.domain.usecases.PatchPostUseCase
import com.example.restapiexampleapp.domain.usecases.PostPostUseCase
import com.example.restapiexampleapp.domain.usecases.PutPostUseCase
import com.example.restapiexampleapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "checkResponse"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val postPostUseCase: PostPostUseCase,
    private val patchPostUseCase: PatchPostUseCase,
    private val putPostUseCase: PutPostUseCase,
    private val deletePostUseCase: DeletePostUseCase
) : ViewModel() {

    private val _allPostsResponse = MutableLiveData<NetworkResult<List<ResponseModel>>>()
    val allPostsResponse: LiveData<NetworkResult<List<ResponseModel>>> = _allPostsResponse

    fun getAllPosts() {
        viewModelScope.launch {
            getAllPostsUseCase.execute().let {
                _allPostsResponse.value = it
                Log.d(TAG, "data ${it.data} message ${it.message}")
            }
        }
    }

    fun postPost() {
        val body = ResponseModel(title = "Test title", body = "Test body")
        viewModelScope.launch {
            postPostUseCase.execute(body = body).let {
                Log.d(TAG, "data ${it.data} message ${it.message}")
            }
        }
    }

    fun patchPost() {
        val body = ResponseModel(title = "Test title", body = "Test body")
        viewModelScope.launch {
            patchPostUseCase.execute(id = 1, body).let {
                Log.d(TAG, "data ${it.data} message ${it.message}")
            }
        }
    }

    fun putPost() {
        val body = ResponseModel(title = "Test title", body = "Test body")
        viewModelScope.launch {
            putPostUseCase.execute(id = 1, body).let {
                Log.d(TAG, "data ${it.data} message ${it.message}")
            }
        }
    }

    fun deletePost() {
        viewModelScope.launch {
            deletePostUseCase.execute(id = 1).let {
                Log.d(TAG, "data ${it.data} message ${it.message}")
            }
        }
    }

}