package com.example.mibodega.ContenidoDLC

import android.content.DialogInterface.OnClickListener
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mibodega.R
import com.example.mibodega.databinding.StructBotellasBinding

class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val binding=StructBotellasBinding.bind(view)

    fun render(BotellaModel:Botella,onClickListener: (Botella)->Unit){
        binding.nombre.text=BotellaModel.nombre
        binding.tipotipo.text=BotellaModel.tipo
        binding.origen.text=BotellaModel.origen
        Glide.with(binding.ivBotella.context).load(BotellaModel.logo).into(binding.ivBotella)

        binding.fav.isChecked = BotellaModel.esfav

        binding.fav.setOnClickListener{
                BotellaModel.esfav=!BotellaModel.esfav
                binding.fav.isChecked=BotellaModel.esfav
                if(BotellaModel.esfav){
                //binding.fav.setButtonDrawable(R.drawable.ic_fav)
                Memoria.agregarFavorito(BotellaModel.nombre)
            } else {
                //binding.fav.setButtonDrawable(R.drawable.ic_nofav)
                Memoria.quitarFavorito(BotellaModel.nombre)
            }
        }

        binding.ivBotella.setOnClickListener{
            Toast.makeText(binding.ivBotella.context,BotellaModel.nombre, Toast.LENGTH_SHORT).show()

        }
        itemView.setOnClickListener{
            onClickListener(BotellaModel)
        }
    }
}