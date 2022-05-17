package com.example.fragmentsapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragmentsapp.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<LoginFragment>(R.id.fragment_container_view)
                addToBackStack(LoginFragment::class.java.canonicalName)
            }
        }
    }

    override fun onStart() {
        Log.d("Activity Lifecycle2", "onStart: A ")
        super.onStart()
    }

    override fun onRestart() {
        Log.d("Activity Lifecycle2", "onRestart: A")
        super.onRestart()

    }

    override fun onResume() {
        Log.d("Activity Lifecycle2", "onResume: A")
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity Lifecycle2", "onPause: A")

    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity Lifecycle2", "onStop: A")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity Lifecycle2", "onDestroy: A")
    }

}