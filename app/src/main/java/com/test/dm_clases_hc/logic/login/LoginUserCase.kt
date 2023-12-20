package com.test.dm_clases_hc.logic.login

import android.content.Context
import android.util.Log
import com.test.dm_clases_hc.data.entities.Users
import com.test.dm_clases_hc.data.repository.DBRepository
import com.test.dm_clases_hc.data.repository.UsersRepository


class LoginUserCase (val connection: DBRepository){
        //connect DB

    fun checkLoginRetunrInt(username: String, pass: String): Int{
        val users= UsersRepository().getListUsers()
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

    suspend fun getUserName(userId:Int):Users{

           /// UserR
        return UsersRepository().getListUsers().first{
            it.id==userId
        }
    }


    suspend fun getUserNameDB(userId:Int, context: Context):Users{

       return   connection.getUserDAO().getOneUser(userId)

    }

    suspend fun insertUsers(){

          if(connection.getUserDAO().getAllUsers().isEmpty()){
              connection.getUserDAO().insertUser(UsersRepository().getListUsers())
          }else{

          }

      }


    suspend  fun getAllUsers():List<Users> = connection.getUserDAO().getAllUsers()

    /*
    fun checkLogin(username: String, pass: String): Boolean{
        val users= UsersRepository().getListUsers()

        val lstUsers=users.filter {
            it.password==pass && it.username==username
        }
        Log.d(Constants.TAG,lstUsers.first().id.toString())
        return lstUsers.isEmpty()

        //return users.contains(Users(username,pass))
    }
*/


}

