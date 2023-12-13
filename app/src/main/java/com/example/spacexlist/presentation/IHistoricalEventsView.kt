package com.example.spacexlist.presentation

import com.example.spacexlist.domain.EventItem

interface IHistoricalEventsView {
    fun showHistoricalEvents(list: List<EventItem>)
}