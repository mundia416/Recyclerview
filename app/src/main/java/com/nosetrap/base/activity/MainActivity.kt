package com.nosetrap.base.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nosetrap.base.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
