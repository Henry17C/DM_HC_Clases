package com.test.dm_clases_hc.data.local.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.dm_clases_hc.data.local.dao.UsersDAO
import com.test.dm_clases_hc.data.local.entities.Users


@Database(
    entities = [Users::class],
    version = 1
)
abstract class DBRepository: RoomDatabase() { // Clase Abstracta -> No se hereda. DBRepository extiende a RoomDataBase, y con RoomDatabase() llamo al constructor primario de la clase.

    abstract  fun getUserDAO(): UsersDAO

}


class DBConnection() { // Genera una conexion
    fun getConnection(context: Context): DBRepository =
         Room.databaseBuilder(
            context,
            DBRepository::class.java, "DBTest" // Nombre del archivo fisico de la DB
        ).build()

}






