package com.example.apppro.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apppro.pojo.FeedResponseItem

@Database(entities = [FeedResponseItem::class],version = 1)
abstract class DatabaseApp : RoomDatabase() {

    abstract fun getDao():IDao

    companion object{
        //visible para otros sub procesos
        @Volatile
        private var INSTANCE : DatabaseApp? = null

        //función para retornar Database se  instancia en el viewmodel
        fun getDataBase(context: Context): DatabaseApp {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    DatabaseApp::class.java,
                    "gameDao")
                    .build()
                INSTANCE = instance
                return instance
            }
        }


    }
}