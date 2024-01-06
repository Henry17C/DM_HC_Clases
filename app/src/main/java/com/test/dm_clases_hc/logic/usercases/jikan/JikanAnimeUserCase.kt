package com.test.dm_clases_hc.logic.usercases.jikan

import android.util.Log
import com.coyago.testapp.ui.core.Constants
import com.test.dm_clases_hc.data.network.endpoint.AnimeEndPoint
import com.test.dm_clases_hc.data.network.endpoint.RetrofitBase
import com.test.dm_clases_hc.data.network.endpoint.jikan.anime.getFullAnimeLG
import com.test.dm_clases_hc.logic.entities.FullInfoAnimeLG

class JikanAnimeUserCase {


    fun getAnimeFullInformation(nameAnime:Integer): FullInfoAnimeLG {

        val baseService=RetrofitBase.getRetrofitJikanConnection()
        val service= baseService.create(AnimeEndPoint::class.java)

        val call =service.getAnimeFullInfo(nameAnime)
        var infoAnime: FullInfoAnimeLG = FullInfoAnimeLG()

        if(call.isSuccessful){

            val a = call.body()!!
            infoAnime = a.getFullAnimeLG()
        }
        else {
            Log.d(Constants.TAG,"Error en el llamado de la  API Jikan")
        }
            return infoAnime

        }



    fun getAllTopsAnimes(){

    }

    }



