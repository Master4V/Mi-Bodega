package com.example.mibodega

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mibodega.ContenidoDLC.Botella
import com.example.mibodega.ContenidoDLC.BotellaAdapter
import com.example.mibodega.ContenidoDLC.BotellaProvaider
import com.example.mibodega.databinding.FragmentContenidoBinding

class ContenidoFragment : Fragment() {
    private var _binding: FragmentContenidoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContenidoBinding.inflate(inflater, container, false)
        val view = binding.root

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()

        return view
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        binding.recyclo.layoutManager = manager
        binding.recyclo.adapter = BotellaAdapter(BotellaProvaider.listaBotellas) { botella ->
            onItemSelected(botella)
        }
    }

    private fun onItemSelected(botella: Botella) {
        //Toast.makeText(requireContext(), botella.nombre, Toast.LENGTH_SHORT).show()
        val bundle = Bundle().apply {
            putParcelable("botella", botella)
        }
        findNavController().navigate(R.id.action_contenidoFragment2_to_moreFragment, bundle)
    }
}
