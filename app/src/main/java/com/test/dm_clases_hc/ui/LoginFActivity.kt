package com.test.dm_clases_hc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.dm_clases_hc.logic.login.Login
import com.coyago.testapp.ui.core.Constants
import com.google.android.material.snackbar.Snackbar
import com.test.dm_clases_hc.R
import com.test.dm_clases_hc.databinding.ActivityLoginfBinding

class LoginFActivity : AppCompatActivity() {



    private lateinit var binding: ActivityLoginfBinding///manejo global de las variables,
    // este debe corresponder al nombre del a clase, se va cearse lueg, no se cuando pero se crea, es nula



    private val login: com.test.dm_clases_hc.logic.login.Login = com.test.dm_clases_hc.logic.login.Login()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginf)

        //setContentView(R.layout.activity_login) ya no lo necesite
        binding= ActivityLoginfBinding.inflate(layoutInflater)
        setContentView(binding.root)// me dice que hay una realcion aqui y que recupere




    }


    override fun onStart() {
        super.onStart()
        initControls()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun initControls(){
        binding.btnLogin.setOnClickListener{
            var user=binding.etUser.text.toString()
            var pass=binding.etPassword.text.toString()

            if(!login.checkUserAndPassword(user,pass)){
                Snackbar.make(binding.btnLogin,"usuario o" +
                        "password incorrecto", Snackbar.LENGTH_LONG).show()
            }else{

                //EXPLLICITO
                val intent= Intent(this,MainActivity::class.java)
                intent.putExtra(Constants.TEXT_VARIABLE,"mi primera chamba")
                intent.putExtra(Constants.USER_NAME,user)
                startActivity(intent)
            }

        }

        //IMPLLICITO
        binding.btnShare.setOnClickListener {
            val intentImpl=Intent()
            intentImpl.action=Intent.ACTION_SEND
            intentImpl.putExtra(Intent.EXTRA_TEXT
                ,"Mi primera chamba")
            intentImpl.type="text/plain"


            startActivity(intentImpl)
        }

        binding.btnNXTSign.setOnClickListener {
            val intentSign= Intent(this,SignActivity::class.java)
            intentSign.putExtra(Constants.TEXT_VARIABLE,"mi segunda chamba")
            startActivity(intentSign)
        }

    }















}