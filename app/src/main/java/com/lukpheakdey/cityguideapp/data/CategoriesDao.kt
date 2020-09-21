package com.lukpheakdey.cityguideapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lukpheakdey.cityguideapp.model.Categories

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCategory(categories: Categories)

    @Query("SELECT * FROM categories_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Categories>>

}