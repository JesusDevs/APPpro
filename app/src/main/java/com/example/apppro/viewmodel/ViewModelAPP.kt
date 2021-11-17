package com.example.apppro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apppro.pojo.FeedResponseItem
import com.example.apppro.remote.RepoApp
import kotlinx.coroutines.launch

class ViewModelAPP : ViewModel(){

    private val repository : RepoApp
    val allFeedData : MutableLiveData<List<FeedResponseItem>>
    init {
        repository = RepoApp()
        allFeedData=repository.liveDataFeed
    }

    fun getFeed() = viewModelScope.launch {
        repository.getFeedFromInternetRepo()
    }
}