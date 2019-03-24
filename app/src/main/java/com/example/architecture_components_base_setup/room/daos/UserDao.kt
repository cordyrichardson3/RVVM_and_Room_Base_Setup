package com.example.architecture_components_base_setup.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.architecture_components_base_setup.models.User
import com.example.architecture_components_base_setup.room.QUERY_SELECT_USER


@Dao
interface UserDao: BaseDao<User> {

    @Query(QUERY_SELECT_USER)
    fun getUser(uniqueId: String): LiveData<User>

}