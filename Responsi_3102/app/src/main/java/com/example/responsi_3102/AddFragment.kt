package com.example.responsi_3102

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        // ambil id dari xml
        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val etDesc = view.findViewById<EditText>(R.id.etDesc)
        val etPriority = view.findViewById<EditText>(R.id.etPriority)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        // cek apakah sedang edit (bukan tambah baru)
        val position = arguments?.getInt("position", -1) ?: -1

        // jika edit → tampilkan data yang lama
        if (position != -1) {
            etTitle.setText(arguments?.getString("title"))
            etDesc.setText(arguments?.getString("desc"))
            etPriority.setText(arguments?.getString("priority"))
        }

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val desc = etDesc.text.toString()
            val priority = etPriority.text.toString()

            if (position == -1) {
                // ➕ tambah data ke singleton
                NoteData.notes.add(Note(title, desc, priority))
            } else {
                // ✏️ edit data lama
                NoteData.notes[position] = Note(title, desc, priority)
            }

            parentFragmentManager.setFragmentResult(
                "refresh_list",
                Bundle()
            )

            parentFragmentManager.popBackStack()
        }

        return view
    }
}
