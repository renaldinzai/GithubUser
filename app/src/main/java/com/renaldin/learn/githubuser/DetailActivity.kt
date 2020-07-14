package com.renaldin.learn.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.renaldin.learn.githubuser.model.User
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionbar = supportActionBar
        actionbar?.title = "User Detail"

        actionbar?.setDisplayHomeAsUpEnabled(true)

        addItem()
    }

    private fun addItem() {
        val data = intent.getParcelableExtra<User>("data")

        tv_name.text = data?.name
        tv_username.text = data?.username
        tv_company.text = data?.company
        tv_location.text = data?.location
        tv_repositories.text = getString(R.string.repositories, data?.repository.toString())
        tv_followers.text = getString(R.string.followers, data?.followers.toString())
        tv_following.text = getString(R.string.following, data?.following.toString())

        Glide.with(this)
            .load(data.photo)
            .apply(RequestOptions().override(55, 55))
            .into(img_data_photo)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}