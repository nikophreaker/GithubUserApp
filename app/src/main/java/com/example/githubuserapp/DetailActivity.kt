package com.example.githubuserapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    private val title = "Detail User's"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        toolbar.title = title
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val intent = intent
        val avatar = intent.getIntExtra("avatar",0)
        val username = intent.getStringExtra("username")
        val name = intent.getStringExtra("name")
        val company = intent.getStringExtra("company")
        val lokasi = intent.getStringExtra("lokasi")
        val repository = intent.getStringExtra("repository")
        val followers = intent.getStringExtra("followers")
        val following = intent.getStringExtra("following")
        setData(avatar, username, name, company, lokasi, repository, followers, following)

    }

    private fun setData(
        avatar: Int,
        username: String,
        name: String,
        company: String,
        lokasi: String,
        repository: String,
        followers: String,
        following: String
    ) {
        val savatar = findViewById<ImageView>(R.id.avatar)
        val susername = findViewById<TextView>(R.id.username)
        val sname = findViewById<TextView>(R.id.name)
        val scompany = findViewById<TextView>(R.id.company)
        val slokasi = findViewById<TextView>(R.id.lokasi)
        val srepository = findViewById<TextView>(R.id.repository)
        val sfollowers = findViewById<TextView>(R.id.followers)
        val sfollowng = findViewById<TextView>(R.id.following)
        susername.text = username
        sname.text = name
        scompany.text = company
        slokasi.text = lokasi
        srepository.text = repository
        sfollowers.text = followers
        sfollowng.text = following
        Glide.with(this)
            .load(avatar)
            .apply(RequestOptions().override(250, 250))
            .into(savatar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}