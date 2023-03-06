package com.luu9798.library.network

import com.luu9798.library.model.Book
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("android-test-vaxcare/02cb5f20bf3398ca46884e6c8e18ce89/raw/462e69054eaef1ac92386c549f66324e4b89dbde/local-database.json")
    suspend fun getBooks(): List<Book>
}