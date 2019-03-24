package com.example.architecture_components_base_setup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.architecture_components_base_setup.models.User
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val userViewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val userObserver: Observer<User> = Observer {user->
            user?.let{tv_name.text = it.firstName + " " + it.lastName} ?: Toast.makeText(this, "No user found", Toast.LENGTH_SHORT).show()

        }

        userViewModel.getUser("").observe(this, userObserver)

    }
}