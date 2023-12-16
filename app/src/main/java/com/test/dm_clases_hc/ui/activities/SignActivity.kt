package com.test.dm_clases_hc.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.dm_clases_hc.R
import com.test.dm_clases_hc.logic.login.Sign


class SignActivity : AppCompatActivity() {


    // este debe corresponder al nombre del a clase, se va cearse lueg, no se cuando pero se crea, es nula

    private val singIn: Sign = Sign()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)





    }






}