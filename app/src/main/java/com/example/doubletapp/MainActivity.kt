package com.example.doubletapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var countTextView: TextView
    private val TAG = "MainActivity"
    private val STATE_COUNT = "count"
    private var count: Int = 0
    private var square: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        square = findViewById(R.id.openSecondActivity)
        countTextView = findViewById(R.id.countTextView)


        square?.setOnClickListener {
            val intent = Intent(this, SquareActivity::class.java)
            updateCount();
            intent.putExtra("count", count)
            startActivity(intent)
        }
        updateCount();
    }

    private fun updateCount() {
        countTextView.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        count++
        outState.putInt(STATE_COUNT, count)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(STATE_COUNT)
        updateCount()
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.i(TAG, "onDestroy")
        count++
        updateCount()
    }
}


