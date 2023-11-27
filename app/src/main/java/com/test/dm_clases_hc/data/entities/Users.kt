package com.test.dm_clases_hc.data.entities

data class Users(var id: Int,
                 var userName: String,
                 var password: String)

//nombre, apellido, perfil

data class UserSign(var nombre: String,
                 var apellido: String,
                 var perfil: String)
//costructor vacio-> No existe posibilidad de hacer eso, debe
//tener al menos un parametro

