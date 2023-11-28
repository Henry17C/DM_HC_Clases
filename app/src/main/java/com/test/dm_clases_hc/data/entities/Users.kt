package com.test.dm_clases_hc.data.entities

/*data class Users(var id: Int,
                 var userName: String,
                 var password: String)
*/
//nombre, apellido, perfil

data class UserSign(var nombre: String,
                 var apellido: String,
                 var perfil: String)
//costructor vacio-> No existe posibilidad de hacer eso, debe
//tener al menos un parametro

//{costructor():this(12, "","") }

//inmutable, el usuario en ningun momento podra cambiar
data class Users(var id: Int=-1,
                 var userName: String?=null,
                 var password: String?=null){
    var firstName: String="No registrado"
    var lastName: String="No registrado"
    var profile : String =""

    constructor(id: Int,
    userName: String?,
    password: String?,
    firstName : String,
    lastName: String):this(
    id,
    userName,
    password,
    ){
        this.firstName = firstName;
        this.lastName = lastName
    }}





/* constructor(id:Int , username: String?,
                password: String, profile: String?
    ):this(id,username,password)
    }*/