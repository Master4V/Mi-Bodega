package com.example.mibodega

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mibodega.databinding.FragmentCreditBinding
import com.example.mibodega.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding : FragmentMenuBinding? = null
    private val binding get()=_binding!!
    private val args: MenuFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textoprov.text = getString(R.string.menu, args.nombre)

        binding.BotComenzar.setOnClickListener{
            //findNavController().navigate(R.id.action_menuFragment_to_favoritoFragment3)
            val request = verpag2FragmentDirections.actionVerpag2FragmentToAgarraFragment(nombre = args.nombre)
            findNavController().navigate(request)
        }
        binding.BotSalir.setOnClickListener{
            val request = verpag2FragmentDirections.actionVerpag2FragmentToInicioFragment()
            findNavController().navigate(request)
        }
    }

}