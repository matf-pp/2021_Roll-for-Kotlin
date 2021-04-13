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
        wizardList = arrayListOf(cbControlFlame,cbFirebolt,cbFriends,cbLight,cbMageHand,cbMending,cbMinorIlusion,
            cbAbsorbElements,cbAlarm,cbBurningHands,cbCauseFear,cbCharmPerson,cbColorSpray,cbDetectMagic,cbFeatherFall,cbSilentImage,
            cbBlindDeaf,cdDarkness,cbDarkvision,cdDetectThoughts,cbEnhanceAbility,cbGustOfWind,cbInvisibility,cbMinorImage,cbWeb,
            cbAnimateDead,cbBlink,cbCounterspell,cbDispellMagic,cbFear,cbFly,cbIntellectFortress,cbLifeTransference,cbMajorImage,cbSending,cbSlow,cbSummonFey,cbTongues)

        bardList = arrayListOf(cbFriends,cbLight,cbMageHand,cbMending,cbMinorIlusion,cbViciousMockery,
            cbCharmPerson,cbColorSpray,cbCureWounds,cbDetectMagic,cbHealingWord,cbSilentImage,
            cbAnimalMessenger,cbBlindDeaf,cbCalmEmotion,cdDetectThoughts,cbEnhanceAbility,cbInvisibility,cbMinorImage,cbSilence,
            cbDispellMagic,cbFear,cbIntellectFortress,cbMajorImage,cbMassHealingWord,cbSending,cbSlow,cbTongues)

        clericList = arrayListOf(cbGuidance,cbLight,cbMending,cbSacredFlame,cbSpareTheDying,
            cbBless,cbCureWounds,cbDetectMagic,cbHealingWord,cbInflictWounds,
            cbBlindDeaf,cbCalmEmotion,cbEnhanceAbility,cbFindTraps,cbPrayerOfHealing,cbSilence,cbSpiritualWeapon,
            cbAnimateDead,cbDispellMagic,cbLifeTransference,cbMassHealingWord,cbSending,cbTongues,cbWaterWalk)

        rangerList = arrayListOf(cbAbsorbElements,cbAlarm,cbCureWounds,cbDetectMagic,cbEntangle,
            cbAnimalMessenger,cbDarkvision,cbEnhanceAbility,cbFindTraps,cbGustOfWind,cbSilence,
            cbConjureAnimals,cbLightningArrow,cbSummonFey,cbWaterWalk)
        allList = arrayListOf(cbControlFlame,cbFirebolt,cbFriends,cbGuidance,cbLight,cbMageHand,cbMending,cbMinorIlusion,cbSacredFlame,cbSpareTheDying,cbViciousMockery,
                                cbAbsorbElements,cbAlarm,cbBless,cbBurningHands,cbCauseFear,cbCharmPerson,cbColorSpray,cbCureWounds,cbDetectMagic,cbEntangle,cbFeatherFall,cbHealingWord,cbInflictWounds,cbSilentImage,
                                cbAnimalMessenger,cbBlindDeaf,cbCalmEmotion,cdDarkness,cbDarkvision,cdDetectThoughts,cbEnhanceAbility,cbFindTraps,cbGustOfWind,cbInvisibility,cbMinorImage,cbPrayerOfHealing,cbSilence,cbSpiritualWeapon,cbWeb,
                                cbAnimateDead,cbBlink,cbConjureAnimals,cbCounterspell,cbDispellMagic,cbFear,cbFly,cbIntellectFortress,cbLifeTransference,cbLightningArrow,cbMajorImage,cbMassHealingWord,cbSending,cbSlow,cbSummonFey,cbTongues,cbWaterWalk)


    }

    var oldClass:String = ""
    override fun onStart() {
        if (ActivityScreen1.newCharacter.chClass != oldClass){
            oldClass = ActivityScreen1.newCharacter.chClass
            clearSpells()
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
            }
            "Cleric" -> {
                for(spell in clericList){
                    spell.visibility = View.VISIBLE
                }
                lbPrepare.visibility = View.VISIBLE
                lbCantrip.visibility = View.VISIBLE
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
            }
        }
        lbSpellLevel1.visibility = View.VISIBLE
        lbSpellLevel2.visibility = View.VISIBLE
        lbSpellLevel3.visibility = View.VISIBLE
        lbNoSpell.visibility = View.GONE
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}