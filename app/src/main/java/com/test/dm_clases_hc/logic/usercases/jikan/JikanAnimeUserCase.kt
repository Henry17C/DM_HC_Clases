package com.test.dm_clases_hc.logic.usercases.jikan

import android.util.Log
import com.coyago.testapp.ui.core.Constants
import com.test.dm_clases_hc.data.network.endpoint.AnimeEndPoint
import com.test.dm_clases_hc.data.network.endpoint.RetrofitBase
import com.test.dm_clases_hc.data.network.endpoint.TopAnimeEndPoint
import com.test.dm_clases_hc.data.network.endpoint.jikan.anime.FullInfoAnime
import com.test.dm_clases_hc.data.network.endpoint.jikan.anime.getFullAnimeLG
import com.test.dm_clases_hc.data.network.endpoint.jikan.top.TopAnimes
import com.test.dm_clases_hc.logic.entities.FullInfoAnimeLG

class JikanAnimeUserCase {


    fun getAnimeFullInformation(nameAnime:Integer): FullInfoAnimeLG {

/*

        var infoAnime = ArrayList<TopAnimes>()
        try {
            val baseService = RetrofitBase.getRetrofitJikanConnection()
            val service = baseService.create(AnimeEndPoint::class.java)
            val call = service.getAnimeFullInfo()

            if(call.isSuccessful){
                val a = call.body()!!
                infoAnime.addAll(a)
            }else{
                Log.d(Constants.TAG, "Error en el llamado del API Jikan")
            }
        }catch (ex:Exception){
            Log.e(Constants.TAG, ex.stackTraceToString())
        }
        return infoAnime
        */

        return FullInfoAnimeLG()

        }





    fun getAllTopsAnimes(){

    }

    }



