package com.example.apppro.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.apppro.databinding.FeedItemBinding
import com.example.apppro.pojo.ContactsReponseItem
import com.example.apppro.pojo.FeedResponseItem
import com.example.apppro.viewmodel.ViewModelAPP
import com.jesusdev.gamesfreepc.extensions.loadSvg

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedWH>(){

    private var listFeeditem = listOf<FeedResponseItem>()
    private var listContactItem = listOf<ContactsReponseItem>()


    private var selectedItem = MutableLiveData<FeedResponseItem>()

    fun selectedItem()=selectedItem

    fun update(list: List<FeedResponseItem>){

        listFeeditem=list
        notifyDataSetChanged()


    }


    inner class FeedWH(private val binding: FeedItemBinding) :RecyclerView.ViewHolder(binding.root) ,
        View.OnClickListener{
        override fun onClick(v: View?) {
         selectedItem.value=listFeeditem[adapterPosition]
        }

        fun bind (feedItem: FeedResponseItem){
            binding.titles.text= feedItem.title.uppercase()
            binding.imageView.loadSvg(feedItem.image)
            binding.dates.text = feedItem.date



            itemView.setOnClickListener(this)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedWH {
        return FeedWH(FeedItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FeedWH, position: Int) {
      val feedItem = listFeeditem[position]
        holder.bind(feedItem)
    }

    override fun getItemCount(): Int = listFeeditem.size
}