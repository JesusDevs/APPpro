package com.example.apppro.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apppro.pojo.ContactsReponse
import com.example.apppro.pojo.ContactsReponseItem
import com.example.apppro.pojo.FeedResponseItem

class RepoApp {


    private val retrofit = RetrofitClient.retrofitInstance()
    private val retrofit2 = RetrofitClient.retrofitInstance()
    //variable live data observador del repo, ante un cambio nos actualiza la vista
     val liveDataFeed = MutableLiveData<List<FeedResponseItem>>()
     var liveDataContact = MutableLiveData<List<ContactsReponseItem>>()

    suspend fun getFeedFromInternetRepo(){
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES ")
        val service = kotlin.runCatching { retrofit.getFeed()}
        service.onSuccess {
            liveDataFeed.value = it.body( )
            Log.d("dates","${it.body()}")

        }
        service.onFailure {
            Log.d("ERROR", "$it")
        }}

    suspend fun getContactFromInternetRepo(){
        val serviceContact = kotlin.runCatching { retrofit2.getContact()}
        serviceContact.onSuccess {
            liveDataContact.value = it.body( )
            Log.e("contacts","${it.body()}")

        }
        serviceContact.onFailure {
            Log.d("ERROR", "$it")
        }
        }

       /* */
    }

