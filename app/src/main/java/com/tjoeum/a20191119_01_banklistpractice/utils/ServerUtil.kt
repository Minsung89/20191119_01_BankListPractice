package com.tjoeum.a20191119_01_banklistpractice.utils

import android.content.Context
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

    interface JsonResponseHandler{
        fun onResponse(json: JSONObject)
    }

    companion object{

        //어느 서버에 접속할지 서버 주소를 저장하는 변수
        var BASE_URL = "http://192.168.0.26:5000"

        fun getRequestBankList(context: Context, handler: JsonResponseHandler){

            var client = OkHttpClient()

            var urlBuilder = "${BASE_URL}/info/bank".toHttpUrlOrNull()!!.newBuilder()

            //파라미터가 필요없똬!!!!!
//            urlBuilder.addEncodedQueryParameter()

            var requestUrl = urlBuilder.build().toString()

            var request = Request.Builder().url(requestUrl).build()


            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {

                    val body = response.body!!.string()
                    val json = JSONObject(body)
                    handler?.onResponse(json)
                }

            })
        }

        fun getRequestDeliveryList(context: Context, handler: JsonResponseHandler){

            var client = OkHttpClient()

            var urlBuilder = "${BASE_URL}/info/company".toHttpUrlOrNull()!!.newBuilder()

            //파라미터가 필요없똬!!!!!
//            urlBuilder.addEncodedQueryParameter()

            var requestUrl = urlBuilder.build().toString()

            var request = Request.Builder().url(requestUrl).build()


            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {

                    val body = response.body!!.string()
                    val json = JSONObject(body)
                    handler?.onResponse(json)
                }

            })
        }
    }


}