package com.example.rollforkotlin

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.rollforkotlin.ui.main.SectionsPagerAdapter
import com.example.rollforkotlin.ui.main.adapters.ViewPagerAdapter
import com.example.rollforkotlin.ui.main.fragments.AbilityFragment
import com.example.rollforkotlin.ui.main.fragments.RaceFragment
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
        adapter.addFragment(RaceFragment(), "Race")
        adapter.addFragment(AbilityFragment(), "Ability")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}


