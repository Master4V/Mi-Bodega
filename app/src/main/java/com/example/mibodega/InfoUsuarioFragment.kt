package com.example.mibodega

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.mibodega.ContenidoDLC.AgarraViewModel
import com.example.mibodega.databinding.FragmentInfoUsuarioBinding

class InfoUsuarioFragment : Fragment() {
    private var _binding: FragmentInfoUsuarioBinding?=null
    private val binding get()=_binding!!
    private val viewModel: AgarraViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentInfoUsuarioBinding.inflate(inflater,container,false)

        viewModel.argumento.observe(viewLifecycleOwner) { argumento ->
            binding.prueba.text = getString(R.string.infoUsu,argumento)
        }

        return  binding.root
    }
}