package com.test.dm_clases_hc.data.network.endpoint.jikan.top

data class TopAnimes(
    val `data`: List<com.test.dm_clases_hc.data.network.endpoint.jikan.top.Data>,
    val pagination: com.test.dm_clases_hc.data.network.endpoint.jikan.top.Pagination
)