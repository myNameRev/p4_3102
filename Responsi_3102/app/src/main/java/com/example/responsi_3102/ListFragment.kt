package com.example.responsi_3102

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view.findViewById(R.id.rvNotes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        noteAdapter = NoteAdapter(NoteData.notes)
        recyclerView.adapter = noteAdapter

        // ✅ Ambil tombol tambah
        val btnAdd = view.findViewById<FloatingActionButton>(R.id.btnAddNote)
        btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, AddFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
