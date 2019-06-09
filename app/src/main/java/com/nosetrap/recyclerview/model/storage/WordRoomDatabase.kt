package com.nosetrap.recyclerview.model.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nosetrap.recyclerview.data.Word

@Database(entities = [Word::class],version = 1)
abstract class WordRoomDatabase private constructor():RoomDatabase() {
    companion object{
        private var uniqueInstance: WordRoomDatabase? = null
        fun getInstance(context: Context): WordRoomDatabase{
            if(uniqueInstance == null) {
                uniqueInstance =
                    Room.databaseBuilder(context.applicationContext, WordRoomDatabase::class.java, "word_database")
                        .build()
            }
            return uniqueInstance!!
        }
    }

   abstract fun wordDao(): WordDao
}