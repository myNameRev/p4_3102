package com.example.responsi_3102

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private var title: String? = null
    private var desc: String? = null
    private var priority: String? = null
    private var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString("title")
            desc = it.getString("desc")
            priority = it.getString("priority")
            position = it.getInt("position")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val tvTitle = view.findViewById<TextView>(R.id.tvDetailTitle)
        val tvDesc = view.findViewById<TextView>(R.id.tvDetailDesc)
        val tvPriority = view.findViewById<TextView>(R.id.tvDetailPriority)
        val btnEdit = view.findViewById<Button>(R.id.btnEdit)
        val btnDelete = view.findViewById<Button>(R.id.btnDelete)

        tvTitle.text = title
        tvDesc.text = desc
        tvPriority.text = priority

        // Tombol Edit → buka AddFragment dengan data terisi
        btnEdit.setOnClickListener {
            val editFragment = AddFragment()
            editFragment.arguments = Bundle().apply {
                putString("title", title)
                putString("desc", desc)
                putString("priority", priority)
                putInt("position", position)
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, editFragment)
                .addToBackStack(null)
                .commit()
        }

        // Tombol Hapus → hapus catatan dan kembali ke list
        btnDelete.setOnClickListener {
            if (position != -1) {
                NoteData.notes.removeAt(position)
                parentFragmentManager.popBackStack()
            }
        }

        return view
    }
}
