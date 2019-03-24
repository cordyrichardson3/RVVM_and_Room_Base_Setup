package com.example.architecture_components_base_setup.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.architecture_components_base_setup.models.User
import com.example.architecture_components_base_setup.room.daos.UserDao

/*
Database class for the application. Must be abstract and
extend RoomDatabase
 */

/*
database annotation takes
@param entities: list of classes annotated with @Entity. Each will have a
corresponding table created
 */
@Database(entities = [User::class], version = 1)
abstract class BaseDatabase: RoomDatabase() {
    abstract val userDao: UserDao
    protected lateinit var instance: BaseDatabase


    /*
    implements singleton pattern to get database once for the application.
    Sample used here:
    https://github.com/googlesamples/android-architecture-components/blob/master/BasicRxJavaSampleKotlin/app/src/main/java/com/example/android/observability/persistence/UsersDatabase.kt
     */
    companion object {
        @Volatile private var INSTANCE: BaseDatabase? = null

        fun getInstance(context: Context): BaseDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: buildDatabase(context).also{ INSTANCE = it}
            }


        private fun buildDatabase(context: Context): BaseDatabase =
                Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatabase::class.java,
                    DATABASE_NAME).build()
    }
}



