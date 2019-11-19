package com.tjoeum.a20191119_01_banklistpractice.datas

import org.json.JSONObject

class Bank {

    var id = 0
    var code = ""
    var name = ""
    var logo = ""

    companion object{

        fun getBankFromJsonObject(jsonObject: JSONObject) : Bank{

            val bank = Bank()

            bank.id = jsonObject.getInt("id")
            bank.code = jsonObject.getString("code")
            bank.logo = jsonObject.getString("logo")
            bank.name = jsonObject.getString("name")

            return bank
        }

    }

}