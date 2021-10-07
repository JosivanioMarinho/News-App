package com.josivaniomarinho.newsapp.logic

import androidx.lifecycle.ViewModel
import com.josivaniomarinho.newsapp.domain.User

class SingUpViewModel: ViewModel() {

    val user: User

    init {
        user = User()
    }

    fun updatePersonalData(imagePath: String, name: String, profession: String) {
        user.imagePath = imagePath
        user.name = name
        user.profession = profession
    }

    fun updateAccessData(email: String, password: String) {
        user.email = email
        user.password = password
    }

    fun updateTermsData(terms: Boolean) {
        user.statusTerms = terms
    }
}