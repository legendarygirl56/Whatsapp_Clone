package com.ayushidoshi56.whatsapp_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
            checkNum()
        }

    }

    private fun checkNum() {
        countrycode = ccp.selectedCountryCodeWithPlus
        phonenum = countrycode + PhoneNumEt.text.toString()

        notifyUser()
    }

    private fun notifyUser() {
        MaterialAlertDialogBuilder(this).apply {
            setMessage("We will be verifying the phone number: ${PhoneNumEt.text}  \n" + "Is this ok, or would you like to edit the number?")
            setPositiveButton("OK"){_,_ ->
                showOptActivity()
            }
            setNegativeButton("Edit"){dialog, which->
                dialog.dismiss()
            }
            setCancelable(false)
            create()
            show()
        }
    }

    private fun showOptActivity() {
        Toast.makeText(this,"djf",Toast.LENGTH_LONG).show()
    }


}

