package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_race.*


class DetailsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource( requireActivity(),
                R.array.races, R.layout.spinner_item2)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spAlignment.adapter = adapter

    }

    fun getValues() {
        val alignment = spAlignment.selectedItem.toString()
        val deity = txtDiety.text
        val backstory = txtBackstory.text
        val appearance = txtAppearance.text
        val additional = txtAdditional.text




    }
}