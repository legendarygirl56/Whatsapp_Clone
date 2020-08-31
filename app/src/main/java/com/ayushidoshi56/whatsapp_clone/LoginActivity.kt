package com.ayushidoshi56.whatsapp_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import androidx.core.widget.addTextChangedListener as addTextChangedListener1

class LoginActivity : AppCompatActivity() {

    private lateinit var phonenum:String
    private lateinit var countrycode:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        nextbtn.isEnabled=false
        PhoneNumEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(PhoneNumEt.text.length == 10)
                {
                    nextbtn.isEnabled=true
                }
            }
        })

        nextbtn.setOnClickListener {
            Toast.makeText(this,"djf",Toast.LENGTH_LONG).show()
            checkNum()
        }

    }

    private fun checkNum() {
        countrycode = ccp.selectedCountryCodeWithPlus
        phonenum = countrycode + PhoneNumEt.text.toString()
    }
}

