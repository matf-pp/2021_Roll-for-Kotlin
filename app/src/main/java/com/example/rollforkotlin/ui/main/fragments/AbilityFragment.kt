package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rollforkotlin.ActivityScreen1
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

    override fun onStop() {
        super.onStop()
        getValues()
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
            btnStrength.text = rollStats().toString()
        }
        btnStrengthPlus.setOnClickListener{
            var newStrength = btnStrength.text.toString()
            if (newStrength != "") {
                var newStr = btnStrength.text.toString().toInt() + 1
                if (newStr < 21)
                    btnStrength.text = newStr.toString()
            }
        }
        btnStrengthMinus.setOnClickListener{
            var newStrength = btnStrength.text.toString()
            if (newStrength != "") {
                var newStr = btnStrength.text.toString().toInt() - 1
                if (newStr > -1)
                    btnStrength.text = newStr.toString()
            }
        }

        btnCharisma.setOnClickListener{
            btnCharisma.text = rollStats().toString()
        }
        btnCharismaPlus.setOnClickListener{
            var newCharisma = btnCharisma.text.toString()
            if (newCharisma != "") {
                var newCha = btnCharisma.text.toString().toInt() + 1
                if (newCha < 21)
                    btnCharisma.text = newCha.toString()
            }
        }
        btnCharismaMinus.setOnClickListener{
            var newCharisma = btnCharisma.text.toString()
            if (newCharisma != "") {
                var newCha = btnCharisma.text.toString().toInt() - 1
                if (newCha > -1)
                    btnCharisma.text = newCha.toString()
            }
        }

        btnConstitution.setOnClickListener{
            btnConstitution.text = rollStats().toString()
        }
        btnConstitutionPlus.setOnClickListener{
            var newConstitution = btnConstitution.text.toString()
            if (newConstitution != "") {
                var newCon = btnConstitution.text.toString().toInt() + 1
                if (newCon < 21)
                    btnConstitution.text = newCon.toString()
            }
        }
        btnConstitutionMinus.setOnClickListener{
            var newConstitution = btnConstitution.text.toString()
            if (newConstitution != "") {
                var newCon = btnConstitution.text.toString().toInt() - 1
                if (newCon > -1)
                    btnConstitution.text = newCon.toString()
            }
        }

        btnDexterity.setOnClickListener{
            btnDexterity.text = rollStats().toString()
        }
        btnDexterityPlus.setOnClickListener{
            var newDexterity = btnDexterity.text.toString()
            if (newDexterity != "") {
                var newDex = btnDexterity.text.toString().toInt() + 1
                if (newDex < 21)
                    btnDexterity.text = newDex.toString()
            }
        }
        btnDexterityMinus.setOnClickListener{
            var newDexterity = btnDexterity.text.toString()
            if (newDexterity != "") {
                var newDex = btnDexterity.text.toString().toInt() - 1
                if (newDex > -1)
                    btnDexterity.text = newDex.toString()
            }
        }

        btnIntelligence.setOnClickListener{
            btnIntelligence.text = rollStats().toString()
        }
        btnIntelligencePlus.setOnClickListener{
            var newIntelligence = btnIntelligence.text.toString()
            if (newIntelligence != "") {
                var newInt = btnIntelligence.text.toString().toInt() + 1
                if (newInt < 21)
                    btnIntelligence.text = newInt.toString()
            }
        }
        btnIntelligenceMinus.setOnClickListener{
            var newIntelligence = btnIntelligence.text.toString()
            if (newIntelligence != "") {
                var newInt = btnIntelligence.text.toString().toInt() - 1
                if (newInt > -1)
                    btnIntelligence.text = newInt.toString()
            }
        }

        btnWisdom.setOnClickListener{
            btnWisdom.text = rollStats().toString()
        }
        btnWisdomPlus.setOnClickListener{
            var newWisdom = btnWisdom.text.toString()
            if (newWisdom != "") {
                var newWis = btnWisdom.text.toString().toInt() + 1
                if (newWis < 21)
                    btnWisdom.text = newWis.toString()
            }
        }
        btnWisdomMinus.setOnClickListener{
            var newWisdom = btnWisdom.text.toString()
            if (newWisdom != "") {
                var newWis = btnWisdom.text.toString().toInt() - 1
                if (newWis > -1)
                    btnWisdom.text = newWis.toString()
            }
        }

    }

    fun getValues() {
        ActivityScreen1.newCharacter.chStr = btnStrength.text.toString().toInt()
        ActivityScreen1.newCharacter.chDex = btnDexterity.text.toString().toInt()
        ActivityScreen1.newCharacter.chCon = btnConstitution.text.toString().toInt()
        ActivityScreen1.newCharacter.chInt = btnIntelligence.text.toString().toInt()
        ActivityScreen1.newCharacter.chWis = btnWisdom.text.toString().toInt()
        ActivityScreen1.newCharacter.chCha = btnCharisma.text.toString().toInt()
    }


}