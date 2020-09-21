package com.lukpheakdey.cityguideapp.repository

import androidx.lifecycle.LiveData
import com.lukpheakdey.cityguideapp.data.CategoriesDao
import com.lukpheakdey.cityguideapp.model.Categories

class CategoriesRepository(private val categoriesDao: CategoriesDao) {

    val readAllDataCategory: LiveData<List<Categories>> = categoriesDao.readAllData()

    suspend fun addCategory(categories: Categories){
        categoriesDao.addCategory(categories)
    }

}