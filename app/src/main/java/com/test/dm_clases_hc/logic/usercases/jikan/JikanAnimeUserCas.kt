package com.test.dm_clases_hc.logic.usercases.jikan

import android.util.Log
import com.coyago.testapp.ui.core.Constants
import com.test.dm_clases_hc.data.network.endpoint.AnimeEndPoint
import com.test.dm_clases_hc.data.network.endpoint.RetrofitBase
import com.test.dm_clases_hc.logic.usercases.jikan.entities.FullInfoAnimeLG

class JikanAnimeUserCas {


    fun getAnimeFullInformation(nameAnime:Integer):FullInfoAnimeLG{

        val baseService=RetrofitBase.getRetrofitJikanConnection()
        val service= baseService.create(AnimeEndPoint::class.java)

        val call =service.getAnimeFullInfo(nameAnime)
        val infoAnime: FullInfoAnimeLG= FullInfoAnimeLG()

        if(call.isSuccessful){

            infoAnime.id=call.body()!!.data.mal_id
            infoAnime.name=call.body()!!.data.title_english
            infoAnime.small_image= call.body()!!.data.images.jpg.small_image_url
            infoAnime.big_image= call.body()!!.data.images.jpg.large_image_url
        }
        else {
            Log.d(Constants.TAG,"Error en el API jikan")
        }
            return infoAnime

        }

    }



