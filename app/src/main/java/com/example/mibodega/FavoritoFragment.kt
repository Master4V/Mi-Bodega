package com.example.mibodega

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mibodega.ContenidoDLC.Botella
import com.example.mibodega.ContenidoDLC.BotellaAdapter
import com.example.mibodega.ContenidoDLC.BotellaProvaider
import com.example.mibodega.ContenidoDLC.Memoria
import com.example.mibodega.databinding.FragmentFavoritoBinding

class FavoritoFragment : Fragment() {
    private var _binding: FragmentFavoritoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: BotellaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val listaFavoritos = BotellaProvaider.listaBotellas.filter { Memoria.esFavorito(it.nombre) }

        adapter = BotellaAdapter(listaFavoritos) { botella ->
        }

        binding.recycloFav.layoutManager = LinearLayoutManager(requireContext())
        binding.recycloFav.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }

}
