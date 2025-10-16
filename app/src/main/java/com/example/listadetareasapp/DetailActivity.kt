package com.example.listadetareasapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // 1. Obtenemos el "equipaje" (extras) del Intent que inició esta Activity
        val extras = intent.extras

        // 2. Comprobamos que el equipaje no esté vacío y contenga nuestra clave
        if (extras != null) {
            val nombreTarea = extras.getString("NOMBRE_TAREA")

            // 3. Buscamos nuestro TextView en el layout 'activity_detail.xml'
            val textViewDetalle: TextView = findViewById(R.id.textViewDetalleTarea)

            // 4. Asignamos el nombre de la tarea al TextView
            textViewDetalle.text = nombreTarea
        }
    }
}