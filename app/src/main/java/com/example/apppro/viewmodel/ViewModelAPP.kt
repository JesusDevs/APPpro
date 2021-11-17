package com.example.apppro.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.apppro.local.DatabaseApp
import com.example.apppro.pojo.FeedResponseItem
import com.example.apppro.remote.RepoApp

import kotlinx.coroutines.launch

class ViewModelAPP(application: Application): AndroidViewModel(application) {

    private val repository : RepoApp
    val allFeedData : LiveData<List<FeedResponseItem>>

    init {

        repository= RepoApp()
        allFeedData = repository.liveDataFeed
    }

    fun getFeed()= viewModelScope.launch {
        repository.getFeedFromInternetRepo()
    }
}