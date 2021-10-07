package com.josivaniomarinho.newsapp.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.josivaniomarinho.newsapp.R
import com.josivaniomarinho.newsapp.logic.SingUpViewModel
import kotlinx.android.synthetic.main.fragment_sing_up_terms.*
import me.drakeet.materialdialog.MaterialDialog

class SingUpTermsFragment :
    Fragment(),
    CompoundButton.OnCheckedChangeListener,
    View.OnClickListener
{

    var signUpViewModel: SingUpViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sing_up_access, container, false)

        return view
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        cb_terms.isEnabled = isChecked
    }

    override fun onClick(v: View?) {
        var layout = LayoutInflater
            .from(activity)
            .inflate(R.layout.dialog_personal, null, false)

        val tvName = layout.findViewById<TextView>(R.id.tv_name)
        tvName.text = signUpViewModel?.user?.name

        val tvProfession = layout.findViewById<TextView>(R.id.tv_profession)
        tvProfession.text = signUpViewModel?.user?.profession

        val urlImage = Uri.parse(signUpViewModel?.user?.imagePath)
        val imgProfile = layout.findViewById<ImageView>(R.id.iv_profile)
        imgProfile.setImageURI(urlImage)

        MaterialDialog(activity)
            .setContentView(layout)
            .setCanceledOnTouchOutside(true)
            .show()
    }

    override fun onStart() {
        super.onStart()

        signUpViewModel = ViewModelProviders
            .of(requireActivity())
            .get(SingUpViewModel::class.java)

        cb_terms.setOnCheckedChangeListener(this)
        bt_send.setOnClickListener(this)

        onCheckedChanged(null, signUpViewModel?.user?.statusTerms ?: false)
    }

    override fun onPause() {
        super.onPause()

        signUpViewModel?.updateTermsData(cb_terms.isChecked)
    }

}