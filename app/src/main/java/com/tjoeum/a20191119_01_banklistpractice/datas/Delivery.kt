package com.tjoeum.a20191119_01_deliverylistpractice.datas

import org.json.JSONObject

class Delivery {

    var id = 0
    var name = ""
    var logo = ""

    companion object{

        fun getDeliveryFromJsonObject(jsonObject: JSONObject) : Delivery{

            val delivery = Delivery()

            delivery.id = jsonObject.getInt("id")
            delivery.logo = jsonObject.getString("logo")
            delivery.name = jsonObject.getString("name")

            return delivery
        }

    }

}