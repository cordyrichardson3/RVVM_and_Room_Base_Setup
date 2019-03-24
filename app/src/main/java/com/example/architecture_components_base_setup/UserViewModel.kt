package com.example.architecture_components_base_setup

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.architecture_components_base_setup.models.User
import com.example.architecture_components_base_setup.repositories.UserDataSource

class UserViewModel(application:Application): AndroidViewModel(application) {
    private val userDataSource:UserDataSource by lazy{UserDataSource(application.applicationContext)}

    fun getUser(uniqueId: String): LiveData<User> {
        return userDataSource.getUser(uniqueId)
    }

}