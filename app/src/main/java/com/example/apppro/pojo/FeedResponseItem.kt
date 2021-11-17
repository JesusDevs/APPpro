package com.example.apppro.pojo


import com.google.gson.annotations.SerializedName

data class FeedResponseItem(
    @SerializedName("author_id")
    val authorId: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("published")
    val published: String,
    @SerializedName("title")
    val title: String
)