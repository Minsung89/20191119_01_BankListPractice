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
import com.tjoeum.a20191119_01_banklistpractice.datas.Bank
import java.util.zip.Inflater

class BanksAdapter(context: Context, res: Int, bankList: ArrayList<Bank>) : ArrayAdapter<Bank>(context,res,bankList){

    var mContext = context
    var mList = bankList
    var inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.bank_list_item,null)
        }

        var row = tempRow!!

        var logoImg = row.findViewById<ImageView>(R.id.logoImg)
        var bankName = row.findViewById<TextView>(R.id.bankName)

        Glide.with(mContext).load(mList[position].logo).into(logoImg)
        bankName.text = mList[position].name

        return row
    }

}