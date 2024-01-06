package com.test.dm_clases_hc.data.network.endpoint.jikan.anime

data class Data(
    val aired: com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Aired,
    val airing: Boolean,
    val approved: Boolean,
    val background: String,
    val broadcast: com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Broadcast,
    val demographics: List<Any>,
    val duration: String,
    val episodes: Int,
    val explicit_genres: List<Any>,
    val `external`: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.External>,
    val favorites: Int,
    val genres: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Genre>,
    val images: com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Images,
    val licensors: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Licensor>,
    val mal_id: Int,
    val members: Int,
    val popularity: Int,
    val producers: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Producer>,
    val rank: Int,
    val rating: String,
    val relations: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Relation>,
    val score: Double,
    val scored_by: Int,
    val season: String,
    val source: String,
    val status: String,
    val streaming: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Streaming>,
    val studios: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Studio>,
    val synopsis: String,
    val theme: com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Theme,
    val themes: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.ThemeX>,
    val title: String,
    val title_english: String,
    val title_japanese: String,
    val title_synonyms: List<Any>,
    val titles: List<com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Title>,
    val trailer: com.test.dm_clases_hc.data.network.endpoint.jikan.anime.Trailer,
    val type: String,
    val url: String,
    val year: Int
)