package com.example.githubuserapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter (val context: Context,val list: List<User>) : RecyclerView.Adapter<UserAdapter.Holder>(){
    inner class Holder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(LayoutInflater.from(p0.context).inflate(R.layout.item_user,p0,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        val user : User = list[p1]
        p0.view.avatar.setBackgroundResource(user.avatar)
        p0.view.username.text = user.username
        p0.view.name.text = user.name
        p0.view.lokasi.text = user.lokasi
        p0.itemView.setOnClickListener{
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("avatar", user.avatar)
            intent.putExtra("username", user.username)
            intent.putExtra("name", user.name)
            intent.putExtra("company", user.company)
            intent.putExtra("lokasi", user.lokasi)
            intent.putExtra("repository", user.repository)
            intent.putExtra("followers", user.follower)
            intent.putExtra("following", user.following)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }
    }
}

