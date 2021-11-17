package com.example.apppro.remote

import com.example.apppro.pojo.FeedResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface IRetrofitService {

    @GET("/api/feed")
    suspend fun getFeed(): Response<List<FeedResponseItem>>
}