package com.lukpheakdey.cityguideapp.repository

import androidx.lifecycle.LiveData
import com.lukpheakdey.cityguideapp.data.PlaceDao
import com.lukpheakdey.cityguideapp.model.Place

class PlaceRepository(private val placeDao: PlaceDao) {

    val readAllDataPlace: LiveData<List<Place>> = placeDao.readAllDataPlace()

    val readAllDatPlaceWithFeature: LiveData<List<Place>> = placeDao.readAllDatPlaceWithFeature()

    suspend fun addPlace(place: Place) {
        placeDao.addPlace(place)
    }

    fun readAllPlaceByCategory(categoryId: Int) : LiveData<List<Place>> {
        return placeDao.readAllPlaceByCategory(categoryId)
    }

    fun searchPlace(search: String) : LiveData<List<Place>> {
        return placeDao.searchPlace(search)
    }

}