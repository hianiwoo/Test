package com.test.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.presentation.home.home.HomeFragment
import com.test.test.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(
                R.id.container_main,
                HomeFragment()
            )
            .commit()
    }
}