package com.example.apppro.adapter

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.apppro.pojo.FeedResponseItem

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.{

    private var listFeeditem = listOf<FeedResponseItem>()
    private var selectedItem = MutableLiveData<FeedResponseItem>()

    fun selectedItem()=selectedItem
    fun update(list: List<FeedResponseItem>){

        listFeeditem=list
        notifyDataSetChanged()
    }


    inner class FeedWH(private val binding: Bind)
}