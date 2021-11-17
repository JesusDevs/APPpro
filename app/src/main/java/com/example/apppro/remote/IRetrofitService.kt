package com.example.apppro.remote

import com.example.apppro.pojo.FeedResponseItem
import com.example.apppro.pojo.GameFreeItem
import retrofit2.Response
import retrofit2.http.GET

interface IRetrofitService {
    @GET("games")
    suspend fun getGames(): Response<List<GameFreeItem>>
    @GET("/api/feed")
    suspend fun getFeed(): Response<List<FeedResponseItem>>
}