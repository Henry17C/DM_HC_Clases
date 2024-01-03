package com.test.dm_clases_hc.data.core

import android.app.Application
import com.test.dm_clases_hc.data.network.repository.DBConnection
import com.test.dm_clases_hc.data.network.repository.DBRepository
import com.test.dm_clases_hc.logic.usercases.local.login.LoginUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// Clase donde voy a tener el control de la aplicación, en general, no solo de un activity
class My_Applycation:Application() {


    override fun onCreate() {
        super.onCreate()
        con = DBConnection().getConnection(applicationContext)

        GlobalScope.launch(Dispatchers.IO){

            LoginUserCase(con).insertUsers()

        }


    }

    //objeto que pertenece a la clase
   companion object{
        private lateinit var con: DBRepository

        fun getConnectionDB(): DBRepository {
           return con
                    }
   }

}