package com.example.spacexlist.domain

import com.example.spacexlist.data.model.Event

class EventMapper : Mapper<Event, EventItem> {
    override fun map(event: Event): EventItem {
        return EventItem(
            title = event.title,
            eventDateUtc = event.eventDateUtc,
            flightNumber = event.flightNumber,
            details = event.details
        )
    }
}
