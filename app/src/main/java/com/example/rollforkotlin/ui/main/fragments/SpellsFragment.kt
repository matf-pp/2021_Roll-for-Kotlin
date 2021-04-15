package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.example.rollforkotlin.ActivityScreen1
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_spells.*


class SpellsFragment : Fragment() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    // Cuvanje lista spellova
    lateinit var wizardList: ArrayList<CheckBox>
    lateinit var bardList: ArrayList<CheckBox>
    lateinit var clericList: ArrayList<CheckBox>
    lateinit var rangerList: ArrayList<CheckBox>
    lateinit var allList: ArrayList<CheckBox>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spells, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wizardList = arrayListOf(cbCanControlFlame,cbCanFirebolt,cbCanFriends,cbCanLight,cbCanMageHand,cbCanMending,cbCanMinorIlusion,
            cbLv1AbsorbElements,cbLv1Alarm,cbLv1BurningHands,cbLv1CauseFear,cbLv1CharmPerson,cbLv1ColorSpray,cbLv1DetectMagic,cbLv1FeatherFall,cbLv1SilentImage,
            cbLv2BlindDeaf,cbLv2Darkness,cbLv2Darkvision,cbLv2DetectThoughts,cbLv2EnhanceAbility,cbLv2GustOfWind,cbLv2Invisibility,cbLv2MinorImage,cbLv2Web,
            cbLv3AnimateDead,cbLv3Blink,cbLv3Counterspell,cbLv3DispellMagic,cbLv3Fear,cbLv3Fly,cbLv3IntellectFortress,cbLv3LifeTransference,cbLv3MajorImage,cbLv3Sending,cbLv3Slow,cbLv3SummonFey,cbLv3Tongues)

        bardList = arrayListOf(cbCanFriends,cbCanLight,cbCanMageHand,cbCanMending,cbCanMinorIlusion,cbCanViciousMockery,
            cbLv1CharmPerson,cbLv1ColorSpray,cbLv1CureWounds,cbLv1DetectMagic,cbLv1HealingWord,cbLv1SilentImage,
            cbLv2AnimalMessenger,cbLv2BlindDeaf,cbLv2CalmEmotion,cbLv2DetectThoughts,cbLv2EnhanceAbility,cbLv2Invisibility,cbLv2MinorImage,cbLv2Silence,
            cbLv3DispellMagic,cbLv3Fear,cbLv3IntellectFortress,cbLv3MajorImage,cbLv3MassHealingWord,cbLv3Sending,cbLv3Slow,cbLv3Tongues)

        clericList = arrayListOf(cbCanGuidance,cbCanLight,cbCanMending,cbCanSacredFlame,cbCanSpareTheDying,
            cbLv1Bless,cbLv1CureWounds,cbLv1DetectMagic,cbLv1HealingWord,cbLv1InflictWounds,
            cbLv2BlindDeaf,cbLv2CalmEmotion,cbLv2EnhanceAbility,cbLv2FindTraps,cbLv2PrayerOfHealing,cbLv2Silence,cbLv2SpiritualWeapon,
            cbLv3AnimateDead,cbLv3DispellMagic,cbLv3LifeTransference,cbLv3MassHealingWord,cbLv3Sending,cbLv3Tongues,cbLv3WaterWalk)

        rangerList = arrayListOf(cbLv1AbsorbElements,cbLv1Alarm,cbLv1CureWounds,cbLv1DetectMagic,cbLv1Entangle,
            cbLv2AnimalMessenger,cbLv2Darkvision,cbLv2EnhanceAbility,cbLv2FindTraps,cbLv2GustOfWind,cbLv2Silence,
            cbLv3ConjureAnimals,cbLv3LightningArrow,cbLv3SummonFey,cbLv3WaterWalk)
        allList = arrayListOf(cbCanControlFlame,cbCanFirebolt,cbCanFriends,cbCanGuidance,cbCanLight,cbCanMageHand,cbCanMending,cbCanMinorIlusion,cbCanSacredFlame,cbCanSpareTheDying,cbCanViciousMockery,
                                cbLv1AbsorbElements,cbLv1Alarm,cbLv1Bless,cbLv1BurningHands,cbLv1CauseFear,cbLv1CharmPerson,cbLv1ColorSpray,cbLv1CureWounds,cbLv1DetectMagic,cbLv1Entangle,cbLv1FeatherFall,cbLv1HealingWord,cbLv1InflictWounds,cbLv1SilentImage,
                                cbLv2AnimalMessenger,cbLv2BlindDeaf,cbLv2CalmEmotion,cbLv2Darkness,cbLv2Darkvision,cbLv2DetectThoughts,cbLv2EnhanceAbility,cbLv2FindTraps,cbLv2GustOfWind,cbLv2Invisibility,cbLv2MinorImage,cbLv2PrayerOfHealing,cbLv2Silence,cbLv2SpiritualWeapon,cbLv2Web,
                                cbLv3AnimateDead,cbLv3Blink,cbLv3ConjureAnimals,cbLv3Counterspell,cbLv3DispellMagic,cbLv3Fear,cbLv3Fly,cbLv3IntellectFortress,cbLv3LifeTransference,cbLv3LightningArrow,cbLv3MajorImage,cbLv3MassHealingWord,cbLv3Sending,cbLv3Slow,cbLv3SummonFey,cbLv3Tongues,cbLv3WaterWalk)
        for(cb in allList) cb.setOnClickListener(this)
    }

    //Podesavanje limita za spell-ove
    private var cantripCounter = 0
    private var spell1Counter = 0
    private var spell2Counter = 0
    private var spell3Counter = 0

    var oldClass:String = ""
    override fun onStart() {
        if (ActivityScreen1.newCharacter.chClass != oldClass){
            oldClass = ActivityScreen1.newCharacter.chClass
            clearSpells()
            cantripCounter = ActivityScreen1.newCharacter.chSpellCantripCounter
            spell1Counter = ActivityScreen1.newCharacter.chSpellLvl1Counter
            spell2Counter = ActivityScreen1.newCharacter.chSpellLvl2Counter
            spell3Counter = ActivityScreen1.newCharacter.chSpellLvl3Counter
            lbCantripCount.text = cantripCounter.toString()
            lbSpell1Count.text = spell1Counter.toString()
            lbSpell2Count.text = spell2Counter.toString()
            lbSpell3Count.text = spell3Counter.toString()
        }
        if(ActivityScreen1.newCharacter.chClass=="Bard" || ActivityScreen1.newCharacter.chClass=="Cleric" || ActivityScreen1.newCharacter.chClass=="Ranger" || ActivityScreen1.newCharacter.chClass=="Wizard"){
            showSpells(ActivityScreen1.newCharacter.chClass)
        }
        super.onStart()
    }

    private fun clearSpells() {
        for(spell in allList){
            spell.isChecked = false
        }
    }

    fun showSpells(oldCls: String){
        when(oldCls) {
            "Bard" -> {
                for(spell in bardList){
                    spell.visibility = View.VISIBLE
                }
                lbCantrip.visibility = View.VISIBLE
                lbSelectCantrip.visibility = View.VISIBLE
                lbCantripCount.visibility = View.VISIBLE
            }
            "Cleric" -> {
                for(spell in clericList){
                    spell.visibility = View.VISIBLE
                }
                lbPrepare.visibility = View.VISIBLE
                lbCantrip.visibility = View.VISIBLE
                lbSelectCantrip.visibility = View.VISIBLE
                lbCantripCount.visibility = View.VISIBLE
            }
            "Ranger" -> {
                for(spell in rangerList){
                    spell.visibility = View.VISIBLE
                }
            }
            "Wizard" -> {
                for(spell in wizardList){
                    spell.visibility = View.VISIBLE
                }
                lbCantrip.visibility = View.VISIBLE
                lbSelectCantrip.visibility = View.VISIBLE
                lbCantripCount.visibility = View.VISIBLE
            }
        }
        lbSpellLevel1.visibility = View.VISIBLE
        lbSelectSpell1.visibility = View.VISIBLE
        lbSpell1Count.visibility = View.VISIBLE
        lbSpellLevel2.visibility = View.VISIBLE
        lbSelectSpell2.visibility = View.VISIBLE
        lbSpell2Count.visibility = View.VISIBLE
        lbSpellLevel3.visibility = View.VISIBLE
        lbSelectSpell3.visibility = View.VISIBLE
        lbSpell3Count.visibility = View.VISIBLE
        lbNoSpell.visibility = View.GONE
    }

    override fun onClick(v: View?) {
        v as CheckBox
        val name = v.resources.getResourceName(v.id)
        when(checkSpellType(name)){
            'c' -> {
                if(cantripCounter==0 && v.isChecked){
                    v.isChecked = false
                } else if (v.isChecked){
                    --cantripCounter
                } else {
                    ++cantripCounter
                }
                lbCantripCount.text = cantripCounter.toString()
            }
            '1' -> {
                if(spell1Counter==0 && v.isChecked){
                    v.isChecked = false
                } else if (v.isChecked){
                    --spell1Counter
                } else {
                    ++spell1Counter
                }
                lbSpell1Count.text = spell1Counter.toString()
            }
            '2' -> {
                if(spell2Counter==0 && v.isChecked){
                    v.isChecked = false
                } else if (v.isChecked){
                    --spell2Counter
                } else {
                    ++spell2Counter
                }
                lbSpell2Count.text = spell2Counter.toString()
            }
            '3' -> {
                if(spell3Counter==0 && v.isChecked){
                    v.isChecked = false
                } else if (v.isChecked){
                    --spell3Counter
                } else {
                    ++spell3Counter
                }
                lbSpell3Count.text = spell3Counter.toString()
            }
        }
    }
    private fun checkSpellType(id:String): Char?{
        if(id.startsWith("com.example.rollforkotlin:id/cbCan")){
            return 'c'
        }
        if(id.startsWith("com.example.rollforkotlin:id/cbLv1")){
            return '1'
        }
        if(id.startsWith("com.example.rollforkotlin:id/cbLv2")){
            return '2'
        }
        if(id.startsWith("com.example.rollforkotlin:id/cbLv3")){
            return '3'
        }
        return null
    }

}