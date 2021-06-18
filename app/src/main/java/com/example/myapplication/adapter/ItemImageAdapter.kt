package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.RowItemimageBinding
import com.example.myapplication.model.ItemImageResponse


class ItemImageAdapter(private val context: Context, userList: ArrayList<ItemImageResponse.Data.User>) :
    RecyclerView.Adapter<ItemImageAdapter.MyViewHolder>() {
    private val userList: ArrayList<ItemImageResponse.Data.User> = userList
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val bind: RowItemimageBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.row_itemimage,
            parent,
            false
        )
        return MyViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ItemImageAdapter.MyViewHolder, position: Int) {

        Glide.with(context).load(userList.get(position).items?.get(position)).into(holder.bind.imageViewItem)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class MyViewHolder(bind: RowItemimageBinding) : RecyclerView.ViewHolder(bind.root) {
        val bind: RowItemimageBinding = bind
    }

}


