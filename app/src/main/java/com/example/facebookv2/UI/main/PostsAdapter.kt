package com.example.facebookv2.UI.main;

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.facebookv2.R
import com.example.facebookv2.pojo.PostsModel


class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostHolder>() {

    private var postsArray = ArrayList<PostsModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return postsArray.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(arrayList: ArrayList<PostsModel>){
        this.postsArray = arrayList
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.title.text = postsArray[position].title
        holder.userId.text = postsArray[position].userId.toString()
        holder.body.text = postsArray[position].body
    }

    class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val userId = itemView.findViewById<TextView>(R.id.userid)
        val body = itemView.findViewById<TextView>(R.id.body)
    }
}