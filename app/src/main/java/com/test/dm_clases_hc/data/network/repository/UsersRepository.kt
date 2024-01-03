package com.test.dm_clases_hc.data.network.repository

import com.test.dm_clases_hc.data.local.entities.Users

class
UsersRepository {
     fun getListUsers(): List<Users> {



        var lstUsers = listOf(

            Users( "admin1", "admin1",1) ,
            Users( "admin2", "admin2",2),
            Users( "admin3", "admin3",3),
            Users(  "a","a",4,"Henry","Coyago")

        )
        return lstUsers
    }
}