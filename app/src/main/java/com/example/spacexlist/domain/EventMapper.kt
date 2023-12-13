package com.example.spacexlist.domain

import com.example.spacexlist.data.model.Event

class EventMapper: Mapper<Event, EventItem> {
    override fun map(t: Event): EventItem {
        return EventItem(
            title = t.title,
            event_date_utc = t.event_date_utc,//форматнуть
            flight_number = t.flight_number,
            details = t.details
        )
    }
}
