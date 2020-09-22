package com.lukpheakdey.cityguideapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lukpheakdey.cityguideapp.PlaceDetailActivity
import com.lukpheakdey.cityguideapp.R
import com.lukpheakdey.cityguideapp.model.Place
import kotlinx.android.synthetic.main.all_places_card_design.view.*
import kotlinx.android.synthetic.main.featured_card_design.view.*


/*
class FeatureAdapter(var items: ArrayList<Feature>, val mContext: Context): RecyclerView.Adapter<FeatureViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        lateinit var featureViewHolder : FeatureViewHolder
        featureViewHolder = FeatureViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.featured_card_design, parent, false))
        return featureViewHolder
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {
        holder.initialize(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class FeatureViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var featureTitle = itemView.featured_title
    var featureImage = itemView.featured_image

    fun initialize(items: Feature) {
        featureTitle.text = items.featured_title
        featureImage.setImageResource(items.featured_image)
    }

} */

class FeatureAdapter: RecyclerView.Adapter<FeatureAdapter.MyViewHolder>() {
    lateinit var context: Context

    private var placeList = emptyList<Place>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.featured_card_design, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = placeList[position]
        holder.itemView.featured_title.text = currentItem.place_name.toString()
        holder.itemView.featured_desc.text = currentItem.place_desc.toString()
        holder.itemView.featured_rating.rating = currentItem.star_point.toFloat()

        val urlImage = currentItem.image_url.toString()
        Glide.with(holder.itemView.context).load(urlImage).into(holder.itemView.featured_image)

        holder.itemView.feature_card_id.setOnClickListener {
            var intent = Intent(holder.itemView.context, PlaceDetailActivity::class.java)
            intent.putExtra("PLACE_NAME", currentItem.place_name.toString())
            intent.putExtra("PLACE_DESC", currentItem.place_desc.toString())
            intent.putExtra("PLACE_PHONE", currentItem.phone.toString())
            intent.putExtra("PLACE_ADDRESS", currentItem.address.toString())
            intent.putExtra("PLACE_STAR", currentItem.star_point)
            intent.putExtra("OPEN_TIME", currentItem.open_time)
            intent.putExtra("CLOSE_TIME", currentItem.close_time)
            intent.putExtra("DAY_OPEN", currentItem.day_open)
            intent.putExtra("DAY_CLOSE", currentItem.day_close)
            intent.putExtra("IMAGE_URL", currentItem.image_url)
            intent.putExtra("MAP_URL", currentItem.map_url)
            intent.putExtra("WEBSITE", currentItem.website)
            intent.putExtra("REVIEW", currentItem.review)
            holder.itemView.context.startActivity(intent)
            Toast.makeText(holder.itemView.context, currentItem.place_name.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    fun setData(place: List<Place>) {
        this.placeList = place
        notifyDataSetChanged()
    }
}
