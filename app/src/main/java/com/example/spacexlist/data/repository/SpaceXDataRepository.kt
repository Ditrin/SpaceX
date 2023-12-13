package com.example.spacexlist.data.repository

import com.example.spacexlist.data.model.Event
import com.example.spacexlist.data.remote.Networking

class SpaceXDataRepository {


    suspend fun getAllHistoricalEvents(): List<Event> {

        return Networking.spaceXDataAPI.getAllHistoricalEvents()
    }

}