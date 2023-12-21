package com.example.spacexlist.data.repository

import com.example.spacexlist.data.model.Event
import com.example.spacexlist.data.remote.Networking
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpaceXDataRepository {

    suspend fun getAllHistoricalEvents(): List<Event> =
        withContext(Dispatchers.IO) {
            return@withContext Networking.spaceXDataAPI.getAllHistoricalEvents()
        }
}
