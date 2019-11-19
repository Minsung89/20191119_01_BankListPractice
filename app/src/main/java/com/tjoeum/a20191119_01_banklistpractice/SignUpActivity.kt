package com.tjoeum.a20191119_01_banklistpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setEvents()
        setValues()
    }

    override fun setEvents() {

        passworEdt.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                Log.d("텍스트변경",s.toString())


//                0글자 : #EFEFEF
                //6글자 미만 : #FF0000
                //그 이상 : #00FF00


                if(s.toString().length == 0) {
                    passwordStatusTxt.text = "비밀번호를 입력해주세요."
                    passwordStatusTxt.setTextColor(ContextCompat.getColor(mContext,R.color.zero))
                } else if (s.toString().length < 6) {
                    passwordStatusTxt.text = "길이가 너무 짧습니다."
                    passwordStatusTxt.setTextColor(ContextCompat.getColor(mContext,R.color.red))
                } else {
                    passwordStatusTxt.text = "사용해도 좋은 비밀번호입니다."
                    passwordStatusTxt.setTextColor(ContextCompat.getColor(mContext,R.color.green))
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

    }

    override fun setValues() {
    }
}
