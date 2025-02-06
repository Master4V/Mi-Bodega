package com.example.mibodega.ContenidoDLC

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

object Memoria {
    val favoritos = mutableListOf<String>()

    fun agregarFavorito(nombre: String) {
        if (!favoritos.contains(nombre)) {
            favoritos.add(nombre)
        }
    }

    fun quitarFavorito(nombre: String) {
        favoritos.remove(nombre)
    }

    fun esFavorito(nombre: String): Boolean {
        return favoritos.contains(nombre)
    }
}
class AgarraViewModel : ViewModel() {
    private val _argumento = MutableLiveData<String>()
    val argumento: LiveData<String> get() = _argumento

    fun setArgumento(valor: String) {
        _argumento.value = valor
    }
}