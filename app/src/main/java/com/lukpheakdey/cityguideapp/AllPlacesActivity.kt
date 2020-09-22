package com.lukpheakdey.cityguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukpheakdey.cityguideapp.adapter.AllPlacesAdapter
import com.lukpheakdey.cityguideapp.model.Place
import com.lukpheakdey.cityguideapp.viewmodel.PlaceViewModel
import kotlinx.android.synthetic.main.activity_all_places.*
import androidx.lifecycle.Observer


class AllPlacesActivity : AppCompatActivity() {

    lateinit var placeList: ArrayList<Place>

    private lateinit var mPlaceViewModel: PlaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_places)

        var intent_extra : String? = ""
        intent_extra = intent.getStringExtra("CALL_FROM_CATEGORY")

        // Call all place based on category id
        if(intent_extra!=null){
            val categoryId = intent.getIntExtra("CATEOGRY_ID", 0)
            readAllPlaceByCateogry(categoryId)
            //Toast.makeText(this, "Call from category", Toast.LENGTH_LONG).show()
        }
        // Call all place to visit
        else {
            //Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show()
            placeList = ArrayList()
            allPlaceRecycler()
        }


    }

    // Read All Place
    fun allPlaceRecycler() {
        // RecylerView
        val adapter = AllPlacesAdapter()
        all_places_recycler.adapter = adapter
        all_places_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // PlaceViewModel to read all places
        mPlaceViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)
        mPlaceViewModel.readAllDataPlace.observe(this, Observer {place ->
            adapter.setData(place)
        })
    }

    // Read all place based on Category Id
    fun readAllPlaceByCateogry(category_id: Int) {
        // RecylerView
        val adapter = AllPlacesAdapter()
        all_places_recycler.adapter = adapter
        all_places_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // PlaceViewModel for read places by category id
        mPlaceViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)
        mPlaceViewModel.readAllPlaceByCategory(category_id).observe(this, Observer { place ->
            adapter.setData(place)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}