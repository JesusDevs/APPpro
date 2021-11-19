package com.example.apppro.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.apppro.local.DatabaseApp
import com.example.apppro.pojo.ContactsReponseItem
import com.example.apppro.pojo.FeedResponseItem
import com.example.apppro.pojo.LoginResponse
import com.example.apppro.remote.RepoApp

import kotlinx.coroutines.launch

class ViewModelAPP(application: Application): AndroidViewModel(application) {

    private val repository : RepoApp = RepoApp()
    val allFeedData : LiveData<List<FeedResponseItem>>
    val allContact : LiveData<List<ContactsReponseItem>>
    val logIn : LiveData<LoginResponse>


    init {
        logIn = repository.liveDataLoginResponse
        allFeedData = repository.liveDataFeed
        allContact = repository.liveDataContact
    }

    fun getFeed()= viewModelScope.launch {
        repository.getFeedFromInternetRepo()
    }
    fun getContacts(){ viewModelScope.launch {
        repository.getContactFromInternetRepo()
    }}

}