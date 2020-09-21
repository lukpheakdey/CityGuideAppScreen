package com.lukpheakdey.cityguideapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lukpheakdey.cityguideapp.model.Place

@Dao
interface PlaceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPlace(place: Place)

    @Query("SELECT * FROM place_table ORDER BY id ASC")
    fun readAllDataPlace(): LiveData<List<Place>>

    @Query("SELECT * FROM place_table WHERE feature=1")
    fun readAllDatPlaceWithFeature() : LiveData<List<Place>>

    @Query("SELECT * FROM place_table WHERE category_id =:categoryId")
    fun readAllPlaceByCategory(categoryId: Int) : LiveData<List<Place>>


}