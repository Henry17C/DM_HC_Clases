package com.test.dm_clases_hc.data.repository

import com.test.dm_clases_hc.data.entities.Users

class DBUsers {

    fun getListUsers(): List<Users> {





        var lstUsers = listOf(
            Users(4, "Henry", "Henry"),

            Users(1, "admin1", "admin1"),
            Users(2, "admin2", "admin2"),
            Users(3, "admin3", "admin3")
        )
        return lstUsers
    }



}