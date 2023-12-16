package com.test.dm_clases_hc.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.test.dm_clases_hc.data.entities.Users

@Dao
interface UsersDAO {

    @Query("Select  * from Users ")
    fun getAllUsers():  List<Users>

    @Query("Select * from Users where id= :idUser" )
    fun getOneUser(idUser: Int): Users


    @Insert
    fun insertUser(users: List<Users>)
    @Update
    fun updateUser(users: List<Users>)

    @Delete
    fun DeleteUser(user:Users)





}