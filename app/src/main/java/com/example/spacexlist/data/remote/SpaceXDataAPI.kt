package com.example.spacexlist.data.remote

import com.example.spacexlist.data.model.Event
import retrofit2.http.GET

interface SpaceXDataAPI {
    @GET("v3/history")
    suspend fun getAllHistoricalEvents(): List<Event>
}