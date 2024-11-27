package com.example.mibodega

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_credit)
        val nombre=intent.getStringExtra("Name")
        val botn=findViewById<Button>(R.id.botn)
        val tv=findViewById<TextView>(R.id.texto)

        tv.apply{
            text=getString(R.string.mensaje,nombre)
        }
        botn.setOnClickListener{
            val mailIntent=Intent(Intent.ACTION_SENDTO).apply {
                data= Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("a2017dutuv@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT,"Consulta de la app Mi Bodega")
            }
            startActivity(mailIntent)
        }
    }
}