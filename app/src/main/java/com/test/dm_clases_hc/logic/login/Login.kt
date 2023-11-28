package com.test.dm_clases_hc.logic.login

import android.util.Log
import com.coyago.testapp.ui.core.Constants
import com.test.dm_clases_hc.data.entities.Users
import com.test.dm_clases_hc.data.repository.DBUsers


class Login {

    fun checkUserAndPassword(user: String, pass: String): Boolean {
        val listUsers = DBUsers().getListUsers()



        for (userI in listUsers) {
            if (user == userI.username && pass == userI.password) {
                return true
            }
        }

        return false
    }


    fun checkLogin(username: String, pass: String): Boolean{
        val users= DBUsers().getListUsers()

        val lstUsers=users.filter {
            it.password==pass && it.username==username
        }
        Log.d(Constants.TAG,lstUsers.first().id.toString())
        return lstUsers.isEmpty()

        //return users.contains(Users(username,pass))
    }

    fun checkLoginRetunrInt(username: String, pass: String): Int{
        val users= DBUsers().getListUsers()
        var ret=-1

        val lstUsers=users.filter {
            it.password==pass && it.username==username
        }
        //Log.d(Constants.TAG,lstUsers.first().id.toString())

        if(lstUsers.isNotEmpty()){
          ret=  lstUsers.first().id
        }

        return ret

    }

    fun getUserName(userId:Int):Users{


        return DBUsers().getListUsers().first{
            it.id==userId
        }
    }

}

