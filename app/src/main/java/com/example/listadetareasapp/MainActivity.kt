package com.example.listadetareasapp


import android.content.Intent
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

		val adapter = TareaAdapter(listaDeTareas) { tarea ->
			// Este bloque de código se ejecutará cuando se pulse una fila.
			// La 'tarea' pulsada nos llega como parámetro.

			// 1. Creamos un Intent para ir de MainActivity a DetailActivity
			val intent = Intent(this, DetailActivity::class.java)

			// 2. Añadimos datos extra al Intent (el nombre de la tarea)
			intent.putExtra("NOMBRE_TAREA", tarea.nombre)

			// 3. Iniciamos la nueva Activity
			startActivity(intent)
		}
		recyclerView.adapter=adapter
		recyclerView.layoutManager=LinearLayoutManager(this)


		}
	}
