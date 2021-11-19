package com.example.apppro.remote

import com.example.apppro.pojo.ContactsReponseItem
import com.example.apppro.pojo.FeedResponseItem
import com.example.apppro.pojo.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Body

import retrofit2.http.POST




interface IRetrofitService {

    @GET("/api/feed")
    suspend fun getFeed(): Response<List<FeedResponseItem>>


    @GET("/api/contacts")
    suspend fun getContact(): Response<List<ContactsReponseItem>>

    @POST("api/login")
    fun LogInUser(@Body username : String ,password :String ): Response<LoginResponse>
}