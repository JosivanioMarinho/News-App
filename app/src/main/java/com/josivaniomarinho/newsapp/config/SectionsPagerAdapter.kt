package com.josivaniomarinho.newsapp.config

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.josivaniomarinho.newsapp.activity.SingUpActivity
import com.josivaniomarinho.newsapp.fragments.SingUpPersonalFragment
import com.josivaniomarinho.newsapp.fragments.SingUpAccessFragment
import com.josivaniomarinho.newsapp.fragments.SingUpTermsFragment

/**
 * Um [FragmentPagerAdapter] que retorna um fragment correspondente a
 * uma das seções/tabs/pages.
 */
class SectionsPagerAdapter(activity: SingUpActivity, fm: FragmentManager):
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        /* getItem é invocado para instanciar o fragment da tab informada. */

        return when( position ){
            0 -> SingUpPersonalFragment()
            1 -> SingUpAccessFragment()
            else -> SingUpTermsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}