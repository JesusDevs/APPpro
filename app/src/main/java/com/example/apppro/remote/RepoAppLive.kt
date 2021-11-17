package com.example.apppro.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apppro.local.IDao
import com.example.apppro.pojo.FeedResponseItem
import kotlinx.coroutines.launch

class RepoAppLive(private val dao :IDao) {

    val liveDataBaseAPP: LiveData<List<FeedResponseItem>> = dao.getAllFeedDataBase()



    suspend fun getFeedFromInternetRepo() {
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = RetrofitClient.retrofitInstance().getFeed()
            when (response.isSuccessful) {

                true -> response.body()?.let {
                    //Aca se esta insertando en la Base de datos

                    dao.insertAllFeed(it)
                    Log.d("repo", "$it")
                }
                false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()} ")
            }
        } catch (t: Throwable) {
            Log.e("ERROR CORUTINA", t.message.toString())
        }
    }

}