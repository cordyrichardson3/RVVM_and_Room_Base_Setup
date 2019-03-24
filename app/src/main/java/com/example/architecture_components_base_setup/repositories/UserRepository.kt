package com.example.architecture_components_base_setup.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.architecture_components_base_setup.models.User
import com.example.architecture_components_base_setup.room.BaseDatabase

interface IUserDataSource {
    fun saveNewUser(user: User)
    fun deleteUser(user: User)
    fun updateUser(user: User)
    fun getUser(uniqueId: String): LiveData<User>

}

class UserDataSource(context: Context): IUserDataSource {
    private val localDataSource by lazy {UserLocalDataSource(context)}

    override fun saveNewUser(user: User){}
    override fun deleteUser(user: User){}
    override fun updateUser(user: User){}
    override fun getUser(uniqueId: String): LiveData<User> {
        return localDataSource.getUser(uniqueId)
    }
}

class UserLocalDataSource(context: Context): IUserDataSource {
    private val database: BaseDatabase by lazy{ BaseDatabase.getInstance(context)}


    override fun saveNewUser(user: User){}
    override fun deleteUser(user: User){}
    override fun updateUser(user: User){}
    override fun getUser(uniqueId: String): LiveData<User> {
        return database.userDao.getUser(uniqueId)
    }
}

