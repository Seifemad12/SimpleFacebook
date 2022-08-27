package com.example.facebookv2.UI.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facebookv2.R
import com.example.facebookv2.databinding.ActivityMainBinding
import com.example.facebookv2.pojo.PostsModel

class MainActivity : AppCompatActivity() {
    lateinit var b:ActivityMainBinding
    lateinit var postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        postViewModel.getPosts()
        val adapter = PostsAdapter()
        b.recycle.adapter = adapter
        b.recycle.layoutManager = LinearLayoutManager(this)

        postViewModel.mutabLiveData.observe(this, Observer {
            adapter.setList(it as ArrayList<PostsModel>)

        })
    }
}