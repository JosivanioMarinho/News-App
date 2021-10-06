package com.josivaniomarinho.newsapp.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.josivaniomarinho.newsapp.R
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.fragment_sin_up_personal.*
import me.iwf.photopicker.PhotoPicker

class SingUpPersonalFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sin_up_personal, container, false)

        view
            .findViewById<RoundedImageView>(R.id.iv_profile)
            .setOnClickListener(this)

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
            iv_profile.setImageURI(Uri.parse(imagePath))
        }
    }

}