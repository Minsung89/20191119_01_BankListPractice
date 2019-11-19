package com.tjoeum.a20191119_01_banklistpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tjoeum.a20191119_01_banklistpractice.R
import com.tjoeum.a20191119_01_deliverylistpractice.datas.Delivery
import java.util.zip.Inflater

class DeliveryAdapter(context: Context, res: Int, DeliveryList: ArrayList<Delivery>) : ArrayAdapter<Delivery>(context,res,DeliveryList){

    var mContext = context
    var mList = DeliveryList
    var inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.delivery_list_item,null)
        }

        var row = tempRow!!

        var logoImg = row.findViewById<ImageView>(R.id.deliveryLogoImg)
        var DeliveryName = row.findViewById<TextView>(R.id.deliveryName)

        Glide.with(mContext).load(mList[position].logo).into(logoImg)
        DeliveryName.text = mList[position].name

        return row
    }

}