package com.example.mibodega

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etnom=findViewById<EditText>(R.id.etnom)
        val botom=findViewById<Button>(R.id.btn)

        botom.setOnClickListener{
            if (etnom.text.isEmpty()) {
                Toast.makeText(this, "El campo está vacío", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, CreditActivity::class.java)
                intent.putExtra("Name",etnom.text.toString())
                startActivity(intent)
            }
        }
    }
}