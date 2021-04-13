package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rollforkotlin.ActivityScreen1
import com.example.rollforkotlin.R


class SpellsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spells, container, false)
    }
    var oldClass = ""

    override fun onStart() {
        super.onStart()
        if (ActivityScreen1.newCharacter.chClass != oldClass || oldClass == "") {
            oldClass = ActivityScreen1.newCharacter.chClass
            changeSpells(oldClass)
        }
    }
    
    fun changeSpells(cls:String) {
        // TODO: 13-Apr-21  
    }

}