package com.tjoeum.a20191119_01_banklistpractice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeum.a20191119_01_banklistpractice.adapter.BanksAdapter
import com.tjoeum.a20191119_01_banklistpractice.datas.Bank
import com.tjoeum.a20191119_01_banklistpractice.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity() {

    var bankList = ArrayList<Bank>()
    var banksAdapter : BanksAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setEvents()

    }

    override fun setEvents() {
    }

    override fun setValues() {
        getBanksFromServer()

        banksAdapter = BanksAdapter(mContext,R.layout.bank_list_item,bankList)
        bankListView.adapter = banksAdapter


    }


    fun getBanksFromServer(){

        ServerUtil.getRequestBankList(mContext, object : ServerUtil.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {

                Log.d("서버 응답", json.toString())
                val code = json.getInt("code")


                if(code == 200){
                    val data = json.getJSONObject("data")
                    val banks  = data.getJSONArray("banks")

                    for (i in 0..banks.length()-1){
                        var bankJSONObject = banks.getJSONObject(i)
                        bankList.add(Bank.getBankFromJsonObject(bankJSONObject))
                    }
                    runOnUiThread {
                        banksAdapter?.notifyDataSetChanged()
                    }

                }else{
                    Toast.makeText(mContext,"서버 통신에 문제가 있습니다.",Toast.LENGTH_SHORT).show()

                }


            }

        })

    }

}
