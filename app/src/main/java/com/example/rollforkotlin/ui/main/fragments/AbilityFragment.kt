package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_ability.*
import kotlin.random.Random


class AbilityFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ability, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnStrength.setOnClickListener{
            val rand = Random.nextInt(1,21)
            btnStrength.text = rand.toString()
        }
        btnCharisma.setOnClickListener{
            val rand = Random.nextInt(1,21)
            btnCharisma.text = rand.toString()
        }
        btnConstitution.setOnClickListener{
            val rand = Random.nextInt(1,21)
            btnConstitution.text = rand.toString()
        }
        btnDexterity.setOnClickListener{
            val rand = Random.nextInt(1,21)
            btnDexterity.text = rand.toString()
        }
        btnIntelligence.setOnClickListener{
            val rand = Random.nextInt(1,21)
            btnIntelligence.text = rand.toString()
        }
        btnWisdom.setOnClickListener{
            val rand = Random.nextInt(1,21)
            btnWisdom.text = rand.toString()
        }
    }

}