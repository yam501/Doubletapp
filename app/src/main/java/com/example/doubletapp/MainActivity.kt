package com.example.doubletapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
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

        square?.setOnClickListener {
            count++
            val intent = Intent(this, SquareActivity::class.java)
            updateCount();
            intent.putExtra("count", count)
            startActivity(intent)
        }

        countTextView = findViewById(R.id.countTextView)
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(STATE_COUNT);
        }
        updateCount();
    }

    private fun updateCount() {
        countTextView.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_COUNT, count)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        count++
        updateCount()
    }
}


