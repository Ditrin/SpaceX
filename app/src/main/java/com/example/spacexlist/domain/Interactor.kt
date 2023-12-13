package com.example.spacexlist.domain

import com.example.spacexlist.data.repository.SpaceXDataRepository

class Interactor constructor(
    private val eventMapper: EventMapper,
    private val repository: SpaceXDataRepository
) {
    suspend fun getEventItemList() : List<EventItem>{
        return repository.getAllHistoricalEvents().map {eventMapper.map(it)}
    }
}