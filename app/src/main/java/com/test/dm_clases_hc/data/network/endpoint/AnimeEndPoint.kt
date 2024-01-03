package com.test.dm_clases_hc.data.network.endpoint

import com.test.dm_clases_hc.data.network.entities.jikan.anime.FullInfoAnime
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path

interface AnimeEndPoint {


    @GET("anime/{id}/full")
    fun getAnimeFullInfo(@Path("id") name: Integer): Response<FullInfoAnime> ///Json transformado a dataclase ´por medio de un plugin


}