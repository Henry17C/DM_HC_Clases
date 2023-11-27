package com.test.dm_clases_hc.logic.login

import com.test.dm_clases_hc.data.repository.DBUsers


class Login {

    fun checkUserAndPassword(user: String, pass: String): Boolean {
        val listUsers = DBUsers().getListUsers()

        println("PANTALLA: $user")
        println("UNOOOO: $pass")

        for (userI in listUsers) {
            // Asegúrate de que userI.userName y userI.password sean cadenas también
            if (user == userI.userName && pass == userI.password) {
                return true
            }
        }

        return false
    }



}

