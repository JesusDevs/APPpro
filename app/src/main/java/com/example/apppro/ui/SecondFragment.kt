package com.example.apppro.ui

import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.htmlEncode
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
    var description = ""
    var dates2: String = ""

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //agregar Metodo Oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            title = it.getString("title", "")
            img = it.getString("img", "")
            idAuthor = it.getString("idAuthor", "")
            description = it.getString("description", "")
            dates2 = it.getString("dates1", "")
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

        listOf(mViewModelAPP.getContacts())
        mViewModelAPP.allContact.observe(viewLifecycleOwner, {
            Log.d("datosenvista", "$it")
            bindContact(it)
        })


        //pasando datos al detail desde bundle first fragment
        binding.titleEd.text = title
        binding.imageView2.loadSvg(img)
        binding.description.text = Html.fromHtml(description)
        binding.dates.text = dates2





        binding.guardarFav.setOnClickListener {
            Toast.makeText(context, "Guardado Como Favorito", Toast.LENGTH_SHORT).show()
        }

        binding.volver.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //metodo para conectar Contact con Feeds , el metodo recibe un listado de ContactItem
    fun bindContact(contactem: List<ContactsReponseItem>) {
        //valida la iguald del id obtenido en el firstfragment para luego comparar con el objeto contactItem

        contactem.map {
            //condicion si el id capturado en el primer fragmento es igual al id de el objeto del
            // listado contactitem se obtiene un solo elemento y setea el valor los campos fisrtName textView ,gender
            Log.i("info","$it")
            if (idAuthor == it.id.toString()) {
                binding.firstName.text = it.firstName
                binding.gender.text = it.gender
              binding.lastName.text=  it.lastName


            }
        }

    }


}

