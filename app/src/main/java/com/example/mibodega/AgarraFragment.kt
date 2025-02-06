package com.example.mibodega

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.example.mibodega.ContenidoDLC.AgarraViewModel
import com.example.mibodega.databinding.FragmentAgarraBinding
import com.example.mibodega.databinding.FragmentVerpag2Binding
import com.google.android.material.bottomnavigation.BottomNavigationView

class AgarraFragment : Fragment() {
    private var _binding : FragmentAgarraBinding? = null
    private val binding get()=_binding!!
    private val args: AgarraFragmentArgs by navArgs()
    private val viewModel: AgarraViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentAgarraBinding.inflate(inflater,container,false)
        val view =binding.root

        // Aplicar WindowInsets para manejar márgenes correctamente
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.setArgumento(args.nombre)

        // Configurar NavController con BottomNavigationView
       /* val navController = findNavController()
        val bottomNavView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavView?.setupWithNavController(navController)
        */
        val navController = childFragmentManager.findFragmentById(R.id.navHostFragment)
            ?.findNavController()
        if (navController != null) {
            binding.bottomNav.setupWithNavController(navController)
        }
        val bundle = Bundle()
        bundle.putString("miArgumento", args.nombre)
        return view
    }

}