package com.josivaniomarinho.newsapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.tabs.TabLayout
import com.josivaniomarinho.newsapp.R
import com.josivaniomarinho.newsapp.config.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_sing_up.*
import me.iwf.photopicker.PhotoPicker
import com.josivaniomarinho.newsapp.fragments.SingUpPersonalFragment

class SingUpActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)

        /**
         * Cria o adapter que vai retornar um fragment para cada uma das três
         * seções da atividade
         */
        mSectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)

        /* Configurando o ViewPager com as seções do adapter. */
        container.adapter = mSectionsPagerAdapter

        container
            .addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs
            .addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    override fun onStart() {
        super.onStart()
        toolbar.title = resources.getString(R.string.title_activity_sign_up)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK
            && requestCode == PhotoPicker.REQUEST_CODE) {

            if (data != null) {
                val photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS)
                val fragment = supportFragmentManager
                    .findFragmentByTag("android:switcher:${container.id}:${mSectionsPagerAdapter?.getItemId(0)}")
                        as SingUpPersonalFragment

                fragment.updatePhoto(photos!!.get(0))
            }
        }
    }

}