package com.example.architecture_components_base_setup.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.architecture_components_base_setup.room.USER_TABLE

@Entity(tableName = USER_TABLE)
data class User(@PrimaryKey val uniqueId: String,
                val firstName: String,
                val lastName: String)