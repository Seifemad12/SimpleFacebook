package com.example.facebookv2.UI.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.facebookv2.data.PostsClient
import com.example.facebookv2.pojo.PostsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class PostViewModel:ViewModel() {
    val mutabLiveData = MutableLiveData<List<PostsModel>>()

    fun getPosts(){
        PostsClient.getInstance().getPosts().enqueue(object:Callback<List<PostsModel>> {
            override fun onResponse(call: Call<List<PostsModel>>,response: Response<List<PostsModel>>) {
                mutabLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<PostsModel>>, t: Throwable) {

            }

        })
    }
}