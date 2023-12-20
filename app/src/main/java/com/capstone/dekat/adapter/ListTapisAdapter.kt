package com.capstone.dekat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.dekat.data.remote.response.ListTapisResponse
import com.capstone.dekat.databinding.ItemTapisBinding

class ListTapisAdapter: ListAdapter<ListTapisResponse, ListTapisAdapter.MyViewHolder>(DIFF_CALLBACK)  {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTapisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    inner class MyViewHolder (private val binding: ItemTapisBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tapis: ListTapisResponse){
            binding.apply {
                Glide.with(itemView)
                    .load(tapis.thumbnail)
                    .into(ivTapis)
                tvTapis.text = tapis.name
            }
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tapis = getItem(position)
        holder.bind(tapis)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(tapis)
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ListTapisResponse)
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListTapisResponse>() {
            override fun areItemsTheSame(oldItem: ListTapisResponse, newItem: ListTapisResponse): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ListTapisResponse, newItem: ListTapisResponse): Boolean {
                return oldItem == newItem
            }
        }

    }
}
