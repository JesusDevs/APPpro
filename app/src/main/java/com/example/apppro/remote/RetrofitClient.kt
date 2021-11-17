package com.example.apppro.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

        companion object{
            //LocalHost , reemplazar IP
            const val BASE_URL = "http://192.168.0.192:3100"
            //servidor de prueba on"http://demo9242172.mockable.io/")
            fun retrofitInstance(): IRetrofitService {
                val retrofitClient = Retrofit.Builder()
                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofitClient.create(IRetrofitService::class.java)
            }
        }
    }
