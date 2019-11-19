package com.tjoeum.a20191119_01_banklistpractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    var mContext = this

    abstract fun setEvents()

    abstract fun setValues()

}