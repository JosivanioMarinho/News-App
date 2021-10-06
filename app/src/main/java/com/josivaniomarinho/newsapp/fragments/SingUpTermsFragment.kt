package com.josivaniomarinho.newsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import com.josivaniomarinho.newsapp.R
import kotlinx.android.synthetic.main.fragment_sing_up_terms.*
import me.drakeet.materialdialog.MaterialDialog

class SingUpTermsFragment :
    Fragment(),
    CompoundButton.OnCheckedChangeListener,
    View.OnClickListener
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sing_up_access, container, false)

        view
            .findViewById<CheckBox>(R.id.cb_terms)
            .setOnClickListener(this)

        view
            .findViewById<Button>( R.id.bt_send )
            .setOnClickListener( this )

        return view
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        cb_terms.isEnabled = isChecked
    }

    override fun onClick(v: View?) {
        var layout = LayoutInflater
            .from(activity)
            .inflate(R.layout.dialog_personal, null, false)

        MaterialDialog(activity)
            .setContentView(layout)
            .setCanceledOnTouchOutside(true)
            .show()
    }

}