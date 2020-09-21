package com.lukpheakdey.cityguideapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "place_table",
    foreignKeys = [ForeignKey(
        entity = Categories::class,
        parentColumns = ["id"],
        childColumns = ["category_id"],
        onDelete = CASCADE)]
)
data class Place(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val place_name: String,
    val place_desc: String,
    val phone: String,
    val address: String,
    val star_point: String,
    val feature: Int,
    val open_time: String,
    val close_time: String,
    val day_open: String,
    val day_close: String,
    val image_url: String,
    val map_url: String,
    val review: String,
    val category_id: Int?
) : Parcelable