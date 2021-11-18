package com.example.apppro.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apppro.R
import com.example.apppro.adapter.FeedAdapter
import com.example.apppro.databinding.FragmentFirstBinding
import com.example.apppro.pojo.FeedResponseItem
import com.example.apppro.viewmodel.ViewModelAPP
import kotlinx.coroutines.launch
import kotlin.math.log

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val mViewModelAPP : ViewModelAPP by activityViewModels()



    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // declarar e instnaciar adapter , recycler
        val adapter = FeedAdapter()
        var idAuthor : String
        binding.rvView.adapter = adapter
        binding.rvView.layoutManager = LinearLayoutManager(context)

            //consulta a api corutina
        mViewModelAPP.getContacts()
        mViewModelAPP.all.observe(viewLifecycleOwner,{
            Log.d("datosenvista","$it")



        })
            mViewModelAPP.getFeed()
            mViewModelAPP.allFeedData.observe(viewLifecycleOwner,{
              adapter.update(it)

            })

adapter.selectedItem().observe(viewLifecycleOwner,{
    it?.let {
        val bundle = Bundle()
            bundle.putString("idAuthor",it.authorId)
            bundle.putString("title",it.title)
            bundle.putString("img",it.image)
            bundle.putString("description",it.description)

        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)

        //consulta a api corutina


    }
})

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}