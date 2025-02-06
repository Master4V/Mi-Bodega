package com.example.mibodega

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mibodega.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {
    private var _binding : FragmentInicioBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentInicioBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener{
            val etnom=binding.etnom.text
            if(etnom.isEmpty()){
                val request= InicioFragmentDirections.actionInicioFragmentToVerpag2Fragment(nombre = "Wawa")
                findNavController().navigate(request)
            }else{
                val request= InicioFragmentDirections.actionInicioFragmentToVerpag2Fragment(nombre = etnom.toString())
                findNavController().navigate(request)
            }
        }
    }
}