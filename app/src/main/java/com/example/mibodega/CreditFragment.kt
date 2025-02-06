package com.example.mibodega

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mibodega.databinding.FragmentCreditBinding
import com.example.mibodega.databinding.FragmentVerpag2Binding

class CreditFragment : Fragment() {
    private var _binding : FragmentCreditBinding? = null
    private val binding get()=_binding!!
    private val args: CreditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentCreditBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.texto.text = getString(R.string.mensaje, args.nombre)
        binding.botn.setOnClickListener{
            val mailIntent= Intent(Intent.ACTION_SENDTO).apply {
                data= Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("a2017dutuv@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT,"Consulta de la app Mi Bodega")
            }
            startActivity(mailIntent)
        }
    }
}