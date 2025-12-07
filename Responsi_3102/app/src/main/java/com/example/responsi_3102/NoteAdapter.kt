package com.example.responsi_3102

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notes: ArrayList<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tvTitle)
        val priority = itemView.findViewById<TextView>(R.id.tvPriority)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]

        holder.title.text = note.title
        holder.priority.text = note.priority

        // Klik item → buka DetailFragment
        holder.itemView.setOnClickListener {
            val detail = DetailFragment()
            detail.arguments = Bundle().apply {
                putString("title", note.title)
                putString("desc", note.desc)
                putString("priority", note.priority)
                putInt("position", position)
            }

            val activity = it.context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, detail)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount() = notes.size
}
