package com.codingblocks.myapplication.extensions

import android.view.View
import android.widget.Button

fun setTextOfButton(btn: Button, text: String, color: Int, size: Float) {
    btn.text = text
    btn.setTextColor(color)
    btn.textSize = size
}

fun Button.setTextProperties (text: String, color: Int, size: Float) {
    this.text = text
    this.setTextColor(color)
    this.textSize = size
}

fun <T: View>  T.someFun() {

}