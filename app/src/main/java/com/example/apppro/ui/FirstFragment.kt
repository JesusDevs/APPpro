package com.example.apppro.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels


import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apppro.R
import com.example.apppro.adapter.FeedAdapter
import com.example.apppro.databinding.FragmentFirstBinding

import com.example.apppro.viewmodel.ViewModelAPP


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val mViewModelAPP: ViewModelAPP by activityViewModels()


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
        binding.rvView.adapter = adapter
        binding.rvView.layoutManager = LinearLayoutManager(context)

        //consulta a api corutina

        mViewModelAPP.getFeed()
        mViewModelAPP.allFeedData.observe(viewLifecycleOwner, {
            adapter.update(it)

        })
        //seleccion de item para actualizar adpater
        adapter.selectedItem().observe(viewLifecycleOwner, {
            it?.let {

                //pasando data
                val bundle = Bundle()
                bundle.putString("idAuthor", it.authorId)
                bundle.putString("title", it.title)
                bundle.putString("img", it.image)
                bundle.putString("description", it.description)
                bundle.putString("dates1", it.date)

                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)


            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}