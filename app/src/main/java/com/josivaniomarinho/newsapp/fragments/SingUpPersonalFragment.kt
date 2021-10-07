package com.josivaniomarinho.newsapp.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.josivaniomarinho.newsapp.R
import com.josivaniomarinho.newsapp.logic.SingUpViewModel
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.fragment_sin_up_personal.*
import me.iwf.photopicker.PhotoPicker

class SingUpPersonalFragment : Fragment(), View.OnClickListener {

    var imgPath: String = ""
    var singUpViewdel: SingUpViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sin_up_personal, container, false)

        return view
    }

    override fun onClick(v: View?) {
        activity?.let {
            PhotoPicker.builder()
                .setPhotoCount(1)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(true)
                .start(it, PhotoPicker.REQUEST_CODE)
        }
    }

    fun updatePhoto(imagePath: String){
        if (!imagePath.isEmpty()) {
            this.imgPath = imagePath
            iv_profile.setImageURI(Uri.parse(imagePath))
        }
    }

    override fun onStart() {
        super.onStart()

        singUpViewdel = ViewModelProviders
            .of(requireActivity())
            .get(SingUpViewModel::class.java)

        iv_profile.setOnClickListener(this)

        updatePhoto(singUpViewdel?.user?.imagePath ?: "" )
        et_name.setText(singUpViewdel?.user?.name)
        et_profession.setText(singUpViewdel?.user?.profession)
    }

    override fun onPause() {
        super.onPause()

        singUpViewdel?.updatePersonalData(
            imgPath,
            et_name.text.toString(),
            et_profession.text.toString()
        )
    }

}