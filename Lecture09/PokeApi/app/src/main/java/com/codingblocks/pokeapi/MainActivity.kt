package com.codingblocks.pokeapi

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*

import java.io.IOException

class MainActivity : AppCompatActivity() {

    //var is variable, can change
    //val is value, can't change (similar to final)
    val url: String = "https://pokeapi.co/api/v2/pokemon/1"

    var result: Result? = null

    val test = version

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // If saveInstanceState is null, skip this line else get the value
        savedInstanceState?.getString("KEY")

        tvResult.setOnClickListener {
            //Code here
        }

        makeNetworkCall(url)
    }

    public fun testFunction(input: Int) {
        Log.e("TAG", "Hello $input, ${input.inc()}")
    }

    //Single line function
    fun getCount() = 5

    //String templates
    public fun testFunctionTwo(input: Int) =
            Log.e("TAG", "Hello $input, ${input.inc()}")


    //Anonymous inner classes
    private fun makeNetworkCall(url: String) {

        globalFunc("Test")

        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call, response: Response) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
