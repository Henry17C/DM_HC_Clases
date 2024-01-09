package com.test.dm_clases_hc.logic.usercases.jikan

import android.util.Log
import com.coyago.testapp.ui.core.Constants
import com.test.dm_clases_hc.data.network.endpoint.AnimeEndPoint
import com.test.dm_clases_hc.data.network.endpoint.RetrofitBase
import com.test.dm_clases_hc.data.network.endpoint.TopAnimeEndPoint
import com.test.dm_clases_hc.data.network.endpoint.jikan.anime.getFullAnimeLG
import com.test.dm_clases_hc.data.network.endpoint.jikan.top.TopAnimes
import com.test.dm_clases_hc.logic.entities.FullInfoAnimeLG

class JikanGetTopAnimesUserCase {
    suspend fun getResponse() : TopAnimes {
        var infoAnime = TopAnimes()
        try {
            val baseService = RetrofitBase.getRetrofitJikanConnection()
            val service = baseService.create(TopAnimeEndPoint::class.java)
            val call = service.getAllTopAnimes()

            if(call.isSuccessful){
                val a = call.body()!!
                infoAnime=a
            }else{
                Log.e(Constants.TAG, "Error en el llamado del API Jikan")
            }
        }catch (ex:Exception){
            Log.e(Constants.TAG, ex.stackTraceToString())
        }
        return infoAnime
    }
}



