package com.rachad.retrofit

import retrofit2.http.GET
import com.rachad.retrofit.Post
import retrofit2.Call
import retrofit2.http.Query

interface ApiInterface {
    @GET("posts")
    fun getPost(@Query("userId") userId: String?): Call<List<Post>>
}