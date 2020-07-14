package com.renaldin.learn.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.renaldin.learn.githubuser.adapter.UserAdapter
import com.renaldin.learn.githubuser.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(this::onItemClick)
        displayList()
        adapter.userList = getUserData()
    }

    private fun onItemClick(user: User) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", user)
        startActivity(intent)
    }

    private fun displayList() {
        val layoutManager = LinearLayoutManager(this)
        rv_users.adapter = adapter
        rv_users.layoutManager = layoutManager
        rv_users.addItemDecoration(
            DividerItemDecoration(
                applicationContext,
                layoutManager.orientation
            )
        )
    }

    private fun getUserData(): MutableList<User> {
        val userList = mutableListOf<User>()
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)

        for (i: Int in dataUsername.indices) {
            val user = User(
                dataName[i],
                dataUsername[i],
                dataCompany[i],
                dataLocation[i],
                dataRepository[i],
                dataFollowers[i],
                dataFollowing[i],
                dataPhoto.getResourceId(i, -1)
            )
            userList.add(user)
        }
        return userList
    }

}