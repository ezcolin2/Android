package com.example.recviewwithaniforposting

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.recviewwithaniforposting.databinding.RecAnimationBinding

class RecAdapter(val datas : Array<String>)
    : RecyclerView.Adapter<RecAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecAnimationBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.binding.root.context,R.anim.rec_animation)
        holder.binding.root.animation = animation
        holder.bind(datas[position])
    }

    override fun getItemCount() = datas.size

    class Holder(val binding: RecAnimationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.txtName.text = data



        }
    }
}
