package com.test.dm_clases_hc.logic.login

import android.util.Log
import com.coyago.testapp.ui.core.Constants
import com.test.dm_clases_hc.data.entities.Users
import com.test.dm_clases_hc.data.repository.DBUsers


class Login {

    fun checkUserAndPassword(user: String, pass: String): Boolean {



/*
        for (userI in listUsers) {
            // Asegúrate de que userI.userName y userI.password sean cadenas también
            if (user == userI.userName && pass == userI.password) {
                return true
            }
        }

        return false

    }


    */

      val users= DBUsers().getListUsers()
        val lstUsers= users.filter { it.password==pass && it.userName==user }
        var ret= -1
        //Log.d(Constants.TAG, lstUsers.first().id.toString())


        if(lstUsers.isEmpty()){
            ret=lstUsers.first().id
        }

        return lstUsers.isEmpty()

}


    fun getUserName(userId: Int): Users {
        return  DBUsers().getListUsers().first(){
            it.id==userId
        }

    }



}