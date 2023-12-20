package com.test.dm_clases_hc.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.dm_clases_hc.data.dao.UsersDAO
import com.test.dm_clases_hc.data.entities.Users

//Define las entidades que participan en la base de datos.
//roporciona un método abstracto para obtener los DAO relacionados con cada entidad.
@Database(
    entities = [Users::class],
    version = 1
)
abstract class DBRepository: RoomDatabase() { // Clase Abstracta -> No se hereda. DBRepository extiende a RoomDataBase, y con RoomDatabase() llamo al constructor primario de la clase.

    abstract  fun getUserDAO():UsersDAO

}

//Se encarga de construir la base de datos Room o entregar una conexión existente a la misma.
//Utiliza Room.databaseBuilder para configurar y crear la base de datos.
class DBConnection() { // Genera una conexion
    fun getConnection(context: Context):DBRepository=
         Room.databaseBuilder(
            context,
            DBRepository::class.java, "DBTest" // Nombre del archivo fisico de la DB
        ).build()

}






