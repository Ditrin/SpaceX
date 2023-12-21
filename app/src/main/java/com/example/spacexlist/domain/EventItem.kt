package com.example.spacexlist.domain

import com.squareup.moshi.Json

data class EventItem(
    val title: String?,
    @Json(name="event_date_utc")
    val eventDateUtc: String?,
    @Json(name="flight_number")
    val flightNumber: Int?,
    val details: String?,
)


