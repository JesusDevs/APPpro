package com.example.apppro.pojo


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "contacts_table" )
data class ContactsReponseItem(

    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastName")
    val lastName: String
)