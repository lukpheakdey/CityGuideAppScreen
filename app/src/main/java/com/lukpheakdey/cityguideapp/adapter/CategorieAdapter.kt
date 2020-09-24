package com.lukpheakdey.cityguideapp.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.lukpheakdey.cityguideapp.R
import com.bumptech.glide.Glide
import com.lukpheakdey.cityguideapp.AllPlacesActivity
import com.lukpheakdey.cityguideapp.model.Categories
import kotlinx.android.synthetic.main.categories_card_design.view.*

class CategorieAdapter: RecyclerView.Adapter<CategorieAdapter.MyViewHolder>() {

    lateinit var context: Context

    private var categoryList = emptyList<Categories>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.categories_card_design, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.itemView.categories_title.text = currentItem.name.toString()
        holder.itemView.background_gradient.setBackgroundColor(Color.parseColor(currentItem.color.toString()))
        var image = currentItem.image.toString()

        if(image == "restaurant_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.restaurant_image)
        } else if(image == "transport_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.transport_image)
        } else if(image == "shopping_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.shopping_image)
        } else if(image == "school_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.school_image)
        } else if(image == "vlog"){
            holder.itemView.categories_image.setImageResource(R.drawable.vlog)
        }
        else {
            val urlImage = "https://i.ibb.co/vL9NP6X/transport-image.png"
            //Glide.with(context).load(urlImage).centerCrop().into(holder.itemView.categories_image)
            Glide.with(holder.itemView.context).load(urlImage).into(holder.itemView.categories_image)
        }

        holder.itemView.background_gradient.setOnClickListener {
            val categoryId = currentItem.id
            var intent = Intent(holder.itemView.context, AllPlacesActivity::class.java)
            intent.putExtra("CALL_FROM_CATEGORY", "call_from_category")
            intent.putExtra("CATEOGRY_ID", categoryId)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setData(category: List<Categories>){
        this.categoryList = category
        notifyDataSetChanged()
    }
}




