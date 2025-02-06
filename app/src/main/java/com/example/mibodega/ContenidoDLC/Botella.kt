package com.example.mibodega.ContenidoDLC

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Botella(
    val nombre: String,
    val tipo: String,
    val origen: String,
    val logo: String,
    val descripcion: String,
    var esfav:Boolean= false
) : Parcelable
