package com.example.doubletapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SquareActivity: AppCompatActivity()  {
    private val TAG = "SecondActivity"
    private val STATE_SQUARE = "square"
    private var squareTextView: TextView? = null
    private var square = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        squareTextView = findViewById(R.id.squareTextView);

        if (intent != null && intent.hasExtra("count")) {
            val count = intent.getIntExtra("count", 0)
            square = count * count
            squareTextView?.text = square.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_SQUARE, square)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        square = savedInstanceState.getInt(STATE_SQUARE)
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
}