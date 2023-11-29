package com.test.dm_clases_hc.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
                 var username: String?=null,
                 var password: String?=null
){
    @PrimaryKey(autoGenerate = true)
    var id: Int=-1
    var firstName: String ="No Registrado"
    var lastName: String = "No Registrado"
    var profile:String=""
    //CONSTRUCTOR0
    constructor( username: String?,
        password: String?, id:Int
    ): this(
    username,
    password
    ){this.id=id}

    //CONSTRUCTOR1
    constructor(
        id: Int, username: String?,
        password: String?, profile:String
    ) : this(
        username,
        password
    ){
        this.profile=profile
    }

    //CONSTRUCTOR2
    constructor(
         username: String?,
        password: String?,id: Int, firstName: String, lastName: String
    ) : this(
        username,
        password
    ){
        this.firstName=firstName
        this.lastName=lastName
        this.id=id
    }



}


