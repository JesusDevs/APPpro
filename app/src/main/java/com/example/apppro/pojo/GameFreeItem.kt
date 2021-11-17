package com.example.apppro.pojo


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "game_free" )
data class GameFreeItem(
    @PrimaryKey
    @SerializedName("id")
    val id: Int ,
    @SerializedName("title")
    val title: String ,
    @SerializedName("thumbnail")
    val thumbnail: String ,
    @SerializedName("short_description")
    val shortDescription: String ,
    @SerializedName("game_url")
    val gameUrl: String ,
    @SerializedName("genre")
    val genre: String ,
    @SerializedName("platform")
    val platform: String ,
    @SerializedName("publisher")
    val publisher: String ,
    @SerializedName("developer")
    val developer: String ,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String,
    @SerializedName("fav")
    var fav : Boolean = false
)