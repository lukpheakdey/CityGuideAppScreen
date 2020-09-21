package com.lukpheakdey.cityguideapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukpheakdey.cityguideapp.AllPlacesActivity
import com.lukpheakdey.cityguideapp.R
import com.lukpheakdey.cityguideapp.model.Categories
import kotlinx.android.synthetic.main.card_categorie_and_icon.view.*

class CategoriesCardIconAdapter: RecyclerView.Adapter<CategoriesCardIconAdapter.MyViewHolder>() {

    lateinit var context: Context

    private var categoryList = emptyList<Categories>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_categorie_and_icon, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.itemView.card_category_title.text = currentItem.name.toString()
        val image = currentItem.image.toString()
        if(image == "restaurant_image"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.restaurant_icon)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_1)
        } else if(image == "vlog"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.bank_icon)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_2)
        } else if(image == "school_image"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.school_icon)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_3)
        } else if(image == "shopping_image"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.shop_icon)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_4)
        } else if(image == "transport_image"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.car_icon)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.gradient_color)
        }

        holder.itemView.card_cateory_icon.setOnClickListener {
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