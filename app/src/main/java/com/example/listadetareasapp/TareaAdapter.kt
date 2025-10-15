package com.example.listadetareasapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// El constructor recibe la lista de datos que mostrará
class TareaAdapter(
    private val listaTareas: List<Tarea>,
    private val onItemClick: (Tarea) -> Unit // Esta es una función que recibe una Tarea y no devuelve nada
) : RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    /**
     * El ViewHolder contiene las referencias a las vistas (Views) de nuestro layout item_tarea.xml.
     * Es como una "caja" que guarda los componentes de una fila.
     */
    inner class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTarea: TextView = itemView.findViewById(R.id.textViewNombreTarea)
    }

    /**
     * Se llama cuando el RecyclerView necesita crear un nuevo ViewHolder (una nueva fila).
     * Aquí "inflamos" (creamos) el layout de nuestra fila (item_tarea.xml).
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarea, parent, false)
        return TareaViewHolder(view)
    }

    /**
     * Se llama para vincular los datos de una posición específica (position) con un ViewHolder.
     * Aquí es donde cogemos los datos de la tarea y los ponemos en el TextView de la fila.
     */
    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tareaActual = listaTareas[position]
        holder.nombreTarea.text = tareaActual.nombre

        //Añade un listener a la vista de la fila (itemView)
        holder.itemView.setOnClickListener {
            // Al hacer clic, ejecuta la función que recibimos y pásale la tarea actual
            onItemClick(tareaActual)
        }
    }

    /**
     * Devuelve el número total de ítems en nuestra lista de datos.
     * El RecyclerView lo usa para saber cuántas filas necesita dibujar en total.
     */
    override fun getItemCount(): Int {
        return listaTareas.size
    }
}