package com.test.dm_clases_hc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coyago.testapp.ui.core.Constants
import com.creative.ipfyandroid.Ipfy
import com.creative.ipfyandroid.IpfyClass
import com.google.android.material.snackbar.Snackbar
import com.test.dm_clases_hc.R
import com.test.dm_clases_hc.databinding.ActivityMainBinding
import com.test.dm_clases_hc.logic.login.Login

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Ipfy.init(this) // this is a context of application
        //or you can also pass IpfyClass type to get either IPv4 address only or universal address IPv4/v6 as
        Ipfy.init(this, IpfyClass.IPv4) //to get only IPv4 address
        //and
        Ipfy.init(this,IpfyClass.UniversalIP) //to get Universal address in IPv4/v6

        getIpAddres()
        getGreeting()
        showMessage()

    }


    private fun getGreeting(){
        binding.txtWelcome.text="Bienvenido "
    }

    private fun showMessage(){
        intent.extras.let {
          val userId =  it?.getInt(Constants.USER_ID)

            if(userId!=null){
                val user= Login().getUserName(userId)
                binding.txtShowId.text="User: "+user.firstName.toString()+" "+user.lastName.toString()
            }else{
               Snackbar.make(binding.txtShowId,"Ocurrio un error",Snackbar.LENGTH_LONG).show()
            }


        }
    }


    private fun getIpAddres(){
        Ipfy.getInstance().getPublicIpObserver().observe(this, { ipData ->
            binding.txtIp.text="Su IP es: "+
                ipData.currentIpAddress // this is a value which is your current public IP address, null if no/lost internet connection

        })
    }



}