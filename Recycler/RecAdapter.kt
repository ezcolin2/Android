package com.example.androidstudioclass.Class

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecAdapter(val data : ArrayList<String>)
    : RecyclerView.Adapter<RecAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ListDataBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class Holder(private val binding: ListDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.txtCafe.text = cafe.cafeName
            binding.txtRatingNum.text = String.format("%.2f",cafe.ratings)
            binding.txtRating.rating = cafe.ratings
            binding.txtReviewNum.text = "리뷰 수 : ${cafe.nums}"
            binding.root.setOnClickListener {
                Log.d("cafe",cafe.cafeName)
            }
        }
    }
}
