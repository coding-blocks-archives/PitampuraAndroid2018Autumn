package com.codingblocks.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.codingblocks.myapplication.extensions.setTextProperties
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val p = Person()
        p.fullName = "Arnav Gupta"


        myButton.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Button Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        myButton.setTextProperties(
            "New Text",
            Color.BLUE,
            23.5f
        )


    }
}
