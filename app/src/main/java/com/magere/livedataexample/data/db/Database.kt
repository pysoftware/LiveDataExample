package com.magere.livedataexample.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun personsDao(): PersonsDao

    companion object {
        private const val DB_NAME = "persons_db"
        private var instance: com.magere.livedataexample.data.db.Database? = null

        fun getInstance(context: Context): com.magere.livedataexample.data.db.Database? {
            if (instance == null) {
                synchronized(com.magere.livedataexample.data.db.Database::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        com.magere.livedataexample.data.db.Database::class.java, DB_NAME
                    ).build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }

}