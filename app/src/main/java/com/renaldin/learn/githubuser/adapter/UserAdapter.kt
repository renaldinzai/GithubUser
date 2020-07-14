package com.renaldin.learn.githubuser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.renaldin.learn.githubuser.R
import com.renaldin.learn.githubuser.model.User
import kotlinx.android.synthetic.main.item_row_user.view.*

typealias OnItemClick = (User) -> Unit

class UserAdapter(private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var userList = mutableListOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_user, parent, false)
    )

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(user: User) = view.apply {
            tv_name.text = user.name
            tv_followers.text =
                context.resources.getString(R.string.followers, user.followers.toString())
            tv_following.text =
                context.resources.getString(R.string.following, user.following.toString())
            img_data_photo.setImageResource(user.photo)

            setOnClickListener {
                onItemClick(user)
            }
        }
    }

}