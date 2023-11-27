package com.test.dm_clases_hc.data.repository

import com.test.dm_clases_hc.data.entities.Users

class DBUsers {

    fun getListUsers(): List<Users> {

        var usr1 = Users(1, "admin1", "admin1")
        var usr2 = Users(2, "admin2", "admin2")
        var usr3 = Users(3, "admin3", "admin3")

        var lstUsers = listOf(usr1, usr2, usr3)
        return lstUsers
    }
}