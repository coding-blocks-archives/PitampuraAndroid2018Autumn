package com.codingblocks.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val btn: Button = findViewById(R.id.myButton)
//        btn.setOnClickListener (object: View.OnClickListener {
//            override fun onClick(v: View?) {
//                Toast.makeText(
//                    this@MainActivity,
//                    "Button Clicked",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//
//        })

        myButton.text = "HELLO"

    }
}
