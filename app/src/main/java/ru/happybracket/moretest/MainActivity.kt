package ru.happybracket.moretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.happybracket.moretest.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_container, MainFragment(), "ssdasdsfg")
            .commit()
    }
}