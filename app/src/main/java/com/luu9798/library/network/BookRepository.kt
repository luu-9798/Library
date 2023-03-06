package com.luu9798.library.network

import com.luu9798.library.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookRepository {
    private val retrofitInstance: RetrofitInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(RetrofitInterface::class.java)
    }

    fun getBooks(): Flow<Result<List<Book>>> = flow {
        val response = retrofitInstance.getBooks()
        emit(Result.success(response))
    }.catch { e ->
        emit(Result.failure(e))
    }
}
