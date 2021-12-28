package com.afaf.notesaveretrieve


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViwAdapter(private val notes: List<String>): RecyclerView.Adapter<RecyclerViwAdapter.ViewItemHolder>() {
    class ViewItemHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder {
        return ViewItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewItemHolder, position: Int) {
        val note = notes[position]

        holder.itemView.apply {
            tvNote.text = note
        }
    }

    override fun getItemCount(): Int = notes.size
}