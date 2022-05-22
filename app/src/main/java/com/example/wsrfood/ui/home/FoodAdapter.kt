package com.example.wsrfood.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wsrfood.R
import com.example.wsrfood.server.Food
import com.example.wsrfood.server.MyRetrofit

class FoodAdapter(val context: Context, val list: ArrayList<Food>): RecyclerView.Adapter<FoodAdapter.VH>() {
    class VH(views: View): RecyclerView.ViewHolder(views){
        val img: ImageView = views.findViewById(R.id.food_img)
        val name: TextView = views.findViewById(R.id.food_name)
        val cost: TextView = views.findViewById(R.id.food_cost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.rec_foods, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Glide.with(context).load(MyRetrofit.imgUrl + list[position].icon).into(holder.img)
        holder.name.text = list[position].nameDish
        holder.cost.text = list[position].price
    }

    override fun getItemCount(): Int {
        return list.size
    }
}