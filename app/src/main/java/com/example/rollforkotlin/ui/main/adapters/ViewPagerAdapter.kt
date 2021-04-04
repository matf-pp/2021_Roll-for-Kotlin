package com.example.rollforkotlin.ui.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragList = ArrayList<Fragment>()
    private val mFragTitleList = ArrayList<String>()

    override fun getCount(): Int {
        return mFragList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragList.add(fragment)
        mFragTitleList.add(title)
    }
}