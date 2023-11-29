package com.test.dm_clases_hc.data.repository

import androidx.room.Database
import com.test.dm_clases_hc.data.dao.UsersDAO
import com.test.dm_clases_hc.data.entities.Users


@Database(
    entities=[Users::class],
    version=1
)
abstract class  DBRepository {

    abstract  fun getUserDAO():UsersDAO

}