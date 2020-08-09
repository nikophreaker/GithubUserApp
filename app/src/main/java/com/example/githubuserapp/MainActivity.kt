package com.example.githubuserapp

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val title = "Github User's"
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLokasi: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFolowers: Array<String>
    private lateinit var dataFolowing: Array<String>
    private lateinit var dataAvatar: TypedArray
    var users: MutableList<User> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        toolbar.title = title
        setSupportActionBar(toolbar)

        val rev: RecyclerView = findViewById(R.id.rv)
        rev.addItemDecoration(DividerItemDecoration(baseContext, LinearLayoutManager.HORIZONTAL))
        rev.layoutManager = LinearLayoutManager(this)
        rev.adapter = UserAdapter(baseContext,users)
        prepare()
        addItem()

    }
    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLokasi = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFolowers = resources.getStringArray(R.array.followers)
        dataFolowing = resources.getStringArray(R.array.following)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        users.clear()
        for (position in dataUsername.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataCompany[position],
                dataLokasi[position],
                dataRepository[position],
                dataFolowers[position],
                dataFolowing[position],
                dataAvatar.getResourceId(position, -1)
            )
            users.add(user)
        }
        dataAvatar.recycle()
    }
}