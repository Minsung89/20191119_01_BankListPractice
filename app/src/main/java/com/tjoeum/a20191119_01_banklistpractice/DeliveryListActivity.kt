package com.tjoeum.a20191119_01_banklistpractice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeum.a20191119_01_banklistpractice.adapter.DeliveryAdapter
import com.tjoeum.a20191119_01_banklistpractice.utils.ServerUtil
import com.tjoeum.a20191119_01_deliverylistpractice.datas.Delivery
import kotlinx.android.synthetic.main.activity_delivery_list.*
import org.json.JSONObject

class DeliveryListActivity : BaseActivity() {
    
    var deliveryList = ArrayList<Delivery>()
    var deliverysAdapter : DeliveryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_list)
        setEvents()
        setValues()
    }

    override fun setEvents() {
    }

    override fun setValues() {
        getDeliveryServer()
        deliverysAdapter = DeliveryAdapter(mContext, R.layout.delivery_list_item,deliveryList)
        deliveryCompanyListView.adapter = deliverysAdapter

    }

    fun getDeliveryServer(){
        ServerUtil.getRequestDeliveryList(mContext, object : ServerUtil.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {

                Log.d("서버 응답", json.toString())
                val code = json.getInt("code")


                if(code == 200){
                    val data = json.getJSONObject("data")
                    val company  = data.getJSONArray("company")

                    for (i in 0..company.length()-1){
                        var deliveryJSONObject = company.getJSONObject(i)
                        deliveryList.add(Delivery.getDeliveryFromJsonObject(deliveryJSONObject))
                    }
                    runOnUiThread {
                        deliverysAdapter?.notifyDataSetChanged()
                    }

                }else{
                    Toast.makeText(mContext,"서버 통신에 문제가 있습니다.",Toast.LENGTH_SHORT).show()

                }


            }

        })
    }
}
