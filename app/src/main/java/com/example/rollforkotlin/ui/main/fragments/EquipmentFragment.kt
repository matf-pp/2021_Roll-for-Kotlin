package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_equipment.*
import kotlin.random.Random


class EquipmentFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_equipment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        btnCopper.setOnClickListener {
            btnCopper.text = Random.nextInt(20, 61).toString()
        }
        btnSilver.setOnClickListener {
            btnSilver.text = Random.nextInt(10, 31).toString()
        }
        btnGold.setOnClickListener {
            btnGold.text = Random.nextInt(7, 21).toString()
        }
        btnPlatinum.setOnClickListener {
            btnPlatinum.text = Random.nextInt(0, 3).toString()
        }
    }

}