package com.example.mibodega

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mibodega.ContenidoDLC.Botella
import com.example.mibodega.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentMoreBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botella = arguments?.getParcelable<Botella>("botella")

        botella?.let {
            binding.nombre.text = it.nombre
            binding.tipotipo.text = it.tipo
            binding.origen.text = it.origen
            binding.descripcion.text = it.descripcion

            Glide.with(this).load(it.logo).into(binding.ivBotella)
        }
    }

}