package com.example.apppro.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.apppro.R
import com.example.apppro.adapter.FeedAdapter
import com.example.apppro.databinding.FragmentSecondBinding
import com.example.apppro.pojo.ContactsReponseItem
import com.example.apppro.pojo.FeedResponseItem
import com.example.apppro.viewmodel.ViewModelAPP
import com.jesusdev.gamesfreepc.extensions.loadSvg
import kotlinx.coroutines.job

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val mViewModelAPP: ViewModelAPP by activityViewModels()
    private var listContactItem = listOf<ContactsReponseItem>()
    val adapter = FeedAdapter()
    var idAuthor: String = ""
    var img: String = ""
    var title: String = ""
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //agregar Metodo Oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            title= it.getString("title","")
            img=it.getString("img","")
            idAuthor=it.getString("idAuthor","")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list= arrayListOf<ContactsReponseItem>()


        mViewModelAPP.getContacts()
        //pasando datos al detail desde bundle
        //binding.titleEd.text = title
        binding.imageView2.loadSvg(img)

            mViewModelAPP.allContact.observe(viewLifecycleOwner,{
                Log.d("datosenvista","$it")

            })




      /*  mViewModelAPP.all.observe(viewLifecycleOwner,{
            Log.d("dates","$it")

                adapter.updateContact(it)

        })*/
        /*    binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    */
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun bindContact (contactem: ContactsReponseItem, id :String ){
        binding.titleEd.text = contactem.firstName



    }

}