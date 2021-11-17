package com.example.apppro.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.apppro.local.DatabaseApp
import com.example.apppro.pojo.FeedResponseItem

import com.example.apppro.remote.RepoAppLive
import kotlinx.coroutines.launch

class ViewModelAPP(application: Application): AndroidViewModel(application) {

    private val repository : RepoAppLive
    val allFeedData : LiveData<List<FeedResponseItem>>

    init {
     val dao = DatabaseApp.getDataBase(application).getDao()
        repository= RepoAppLive(dao)
       viewModelScope.launch {
           repository.getdataWithCoroutines()
       }
        allFeedData = repository.liveDataBaseAPP
    }

    fun getFeed() : LiveData<List<FeedResponseItem>> {
        return repository.liveDataBaseAPP
    }
}