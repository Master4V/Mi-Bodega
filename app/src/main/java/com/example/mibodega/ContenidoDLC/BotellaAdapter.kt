package com.example.mibodega.ContenidoDLC

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mibodega.ContenidoDLC.Botella
import com.example.mibodega.R

class BotellaAdapter(private val botellaLista:List<Botella>,private val onClickListener: (Botella)->Unit):RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.struct_botellas, parent, false))
    }

    override fun getItemCount(): Int = botellaLista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = botellaLista[position]
        holder.render(item, onClickListener)
    }
}