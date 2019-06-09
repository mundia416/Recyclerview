package com.nosetrap.recyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.nosetrap.recyclerview.R
import com.nosetrap.recyclerview.model.storage.WordRoomDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
