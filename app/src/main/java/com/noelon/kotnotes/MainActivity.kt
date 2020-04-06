package com.noelon.kotnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val originalText = displayValue.text.toString().toInt()
        val fab = floatingActionButton

        fab.setOnClickListener { view ->
            val newValue = originalText + 1
            displayValue.text = newValue.toString()
        }
    }
}
