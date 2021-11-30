package com.example.adondeirnuevoleon

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import java.util.*

class Formulario : AppCompatActivity() {
    lateinit var opciones: Spinner
    lateinit var text: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)


        //spinner
        opciones=findViewById(R.id.spinner)
        text=findViewById(R.id.mostrar)

        val lista = listOf("Parque Fundidora","Grutas de Garcia", "Paseo Santa Lucia","Cascada Cola de caballo"
        ,"Zoologico la pastora", "Grutas de Bustamante","Museo del Noroeste")

        val adaptador=ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        opciones.adapter=adaptador

        opciones.onItemSelectedListener=object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                text.setText(opciones.selectedItem.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}