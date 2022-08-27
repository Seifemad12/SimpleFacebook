package com.example.facebookv2.data

import com.example.facebookv2.pojo.PostsModel
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPosts():Call<List<PostsModel>>
}