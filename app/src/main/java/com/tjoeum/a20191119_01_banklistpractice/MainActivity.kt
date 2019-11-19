package com.tjoeum.a20191119_01_banklistpractice

import android.os.Bundle
import com.tjoeum.a20191119_01_banklistpractice.datas.Bank

class MainActivity : BaseActivity() {

    var bankList = ArrayList<Bank>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setEvents() {
    }

    override fun setValues() {
        getBanksFromServer()
    }


    fun getBanksFromServer(){

    }

}
