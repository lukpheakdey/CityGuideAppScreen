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

/*
class CategorieAdapter(val mContext: Context, val list: ArrayList<String>) : RecyclerView.Adapter<CategorieAdapter.Holder>() {

    class Holder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.categories_card_design, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = list[position]
    }
}
*/

/* Previous Working */
/*
class CategorieAdapter(var items: ArrayList<Category>, val mContext: Context): RecyclerView.Adapter<CategoryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        lateinit var categoryViewHolder : CategoryViewHolder
        categoryViewHolder = CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.categories_card_design, parent, false))
        return categoryViewHolder
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        if(position % 2 == 0){
            holder.itemView.background_gradient.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark))
        } else {
            holder.itemView.background_gradient.setBackgroundColor(ContextCompat.getColor(mContext, R.color.card4))
        }
        holder.initialize(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var categoryTitle = itemView.categories_title
    var categoryImage = itemView.categories_image

    fun initialize(items: Category) {
        categoryTitle.text = items.title
        categoryImage.setImageResource(items.image)
    }
}
*/

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

        /*
        if(image == "hospital_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.hospital_image)
        } else if(image == "restaurant_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.restaurant_image)
        } else if(image == "transport_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.transport_image)
        } else if(image == "shopping_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.restaurant_image)
        }*/

        if(image == "hospital_image"){
            holder.itemView.categories_image.setImageResource(R.drawable.hospital_image)
        } else {
            val urlImage = "https://i.ibb.co/vL9NP6X/transport-image.png"
            //Glide.with(context).load(urlImage).centerCrop().into(holder.itemView.categories_image)
            Glide.with(holder.itemView.context).load(urlImage).into(holder.itemView.categories_image)
        }

        holder.itemView.background_gradient.setOnClickListener {
            println("*********** PRINT *******")
            println(currentItem.id)
            val categoryId = currentItem.id
            //Toast.makeText(holder.itemView.context, holder.itemView.categories_title.text.toString(), Toast.LENGTH_SHORT).show()
            //Toast.makeText(holder.itemView.context, currentItem.id, Toast.LENGTH_SHORT).show()
            //val category_id = currentItem.id.toInt()
            //Toast.makeText(holder.itemView.context, category_id, Toast.LENGTH_SHORT).show()

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




