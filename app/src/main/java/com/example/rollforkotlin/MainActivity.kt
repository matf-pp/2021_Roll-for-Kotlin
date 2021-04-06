package com.example.rollforkotlin

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.rollforkotlin.ui.main.SectionsPagerAdapter
import com.example.rollforkotlin.ui.main.adapters.ViewPagerAdapter
import com.example.rollforkotlin.ui.main.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_screen1.*


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val tabs: TabLayout = findViewById(R.id.tabs)

        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)


        //Adding all tab fragments
        adapter.addFragment(RaceFragment(), "")
        adapter.addFragment(AbilityFragment(), "")
        adapter.addFragment(ToolsFragment(), "")
        adapter.addFragment(SpellsFragment(), "")
        adapter.addFragment(EquipmentFragment(), "")
        adapter.addFragment(DetailsFragment(), "")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        //setting icons for tabs
        tabs.getTabAt(0)!!.setIcon(R.drawable.sword3)
        tabs.getTabAt(1)!!.setIcon(R.drawable.stats2)
        tabs.getTabAt(2)!!.setIcon(R.drawable.tools)
        tabs.getTabAt(3)!!.setIcon(R.drawable.book1)
        tabs.getTabAt(4)!!.setIcon(R.drawable.bag2)
        tabs.getTabAt(5)!!.setIcon(R.drawable.more)


    }
}


