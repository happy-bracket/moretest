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
            .add(R.id.main_container, MainFragment())
            .commit()
    }

    override fun onBackPressed() {
        // haha navigation goes brrrr
        // me lazy
        if (supportFragmentManager.fragments.size > 1) {
            supportFragmentManager.findFragmentByTag(DETAILS_FRAGMENT_TAG)
                ?.let { fragmentToRemove ->
                    supportFragmentManager.beginTransaction()
                        .remove(fragmentToRemove)
                        .commit()
                }

        } else super.onBackPressed()
    }

    companion object {

        const val DETAILS_FRAGMENT_TAG = "mdaheh"

    }
}