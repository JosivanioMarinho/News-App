package com.josivaniomarinho.newsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.josivaniomarinho.newsapp.R
import com.josivaniomarinho.newsapp.logic.SingUpViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.et_email
import kotlinx.android.synthetic.main.activity_main.et_password
import kotlinx.android.synthetic.main.fragment_sin_up_personal.*
import kotlinx.android.synthetic.main.fragment_sing_up_access.*

class SingUpAccessFragment : Fragment() {

    var singUpViewModel: SingUpViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sing_up_access, container, false)

        return view
    }

    override fun onStart() {
        super.onStart()

        singUpViewModel = ViewModelProviders
            .of(requireActivity())
            .get(SingUpViewModel::class.java)

        et_email_fgm.setText(singUpViewModel?.user?.email)
        et_password_fgm.setText(singUpViewModel?.user?.password)
    }

    override fun onPause() {
        super.onPause()

        singUpViewModel?.updateAccessData(
            et_email_fgm.text.toString(),
            et_password_fgm.text.toString()
        )
    }
}