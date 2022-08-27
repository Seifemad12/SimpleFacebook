package com.example.facebookv2.data

import com.example.facebookv2.pojo.PostsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsClient() {
    private lateinit var postInterface: PostInterface
    companion object{
        const val BaseUrl = "https://jsonplaceholder.typicode.com/"
        var INSTANCE = PostsClient()
        fun getInstance():PostsClient{
            if (INSTANCE==null){
                INSTANCE = PostsClient()
                return INSTANCE
            }
            return INSTANCE
        }
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        postInterface = retrofit.create(PostInterface::class.java)
    }

    fun getPosts():Call<List<PostsModel>>{
        return postInterface.getPosts()
    }


}