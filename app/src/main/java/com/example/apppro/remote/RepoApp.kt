package com.example.apppro.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apppro.pojo.FeedResponseItem

class RepoApp {


    private val retrofit = RetrofitClient.retrofitInstance()

    //variable live data observador del repo, ante un cambio nos actualiza la vista
     val liveDataFeed = MutableLiveData<List<FeedResponseItem>>()

    suspend fun getFeedFromInternetRepo(){
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES PARA OBTENER SALDO")
        val service = kotlin.runCatching { retrofit.getFeed()}
        service.onSuccess {
            liveDataFeed.value = it.body( )
            Log.d("dates","${it.body()}")

        }
        service.onFailure {
            Log.d("ERROR", "$it")
        }}

}