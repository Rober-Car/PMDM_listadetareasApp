package com.example.listadetareasapp

import Tarea
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(R.layout.activity_main)

		// 1. Buscamos el RecyclerView en nuestro layout
		val recyclerView:RecyclerView=findViewById(R.id.recyclerViewTareas)

		// 2. Creamos la lista de datos de ejemplo

		val listaDeTareas=listOf(
			Tarea("Hacer la comida"),
			Tarea("Comprar leche"),
			Tarea("Estudiar para el examen de Android"),
			Tarea("Sacar al perro"),
			Tarea("Hacer la colada"),
			Tarea("Llamar a mamá"),
			Tarea("Ir al gimnasio"),
			Tarea("Preparar la presentación"),
			Tarea("Leer un capítulo del libro")

		)

		// 3. Creamos una instancia de nuestro adaptador y le pasamos la lista de datos

		val adapter=TareaAdapter(listaDeTareas)

		// 4. Conectamos el RecyclerView con nuestro adaptador y le decimos cómo mostrar los elementos
		recyclerView.adapter=adapter
		recyclerView.layoutManager=LinearLayoutManager(this)

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
	}
}