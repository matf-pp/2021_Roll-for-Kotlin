package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_ability.*
import kotlin.math.min
import kotlin.random.Random


class AbilityFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }


    }

    private fun rollStats(): Int{
        val d1 = Random.nextInt(1,7)
        val d2 = Random.nextInt(1,7)
        val d3 = Random.nextInt(1,7)
        val d4 = Random.nextInt(1,7)

        return d1 + d2 + d3 + d4 - min(min(d1,d2),min(d3,d4))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ability, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnStrength.setOnClickListener{
            val rand = rollStats()
            btnStrength.text = rand.toString()
        }
        btnCharisma.setOnClickListener{
            val rand = rollStats()
            btnCharisma.text = rand.toString()
        }
        btnConstitution.setOnClickListener{
            val rand = rollStats()
            btnConstitution.text = rand.toString()
        }
        btnDexterity.setOnClickListener{
            val rand = rollStats()
            btnDexterity.text = rand.toString()
        }
        btnIntelligence.setOnClickListener{
            val rand = rollStats()
            btnIntelligence.text = rand.toString()
        }
        btnWisdom.setOnClickListener{
            val rand = rollStats()
            btnWisdom.text = rand.toString()
        }
    }

}