package com.example.spacexlist.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Event(
    val id: Int?,
    val title: String?,
    @Json(name="event_date_utc")
    val eventDateUtc: String?,
    @Json(name="event_date_unix")
    val eventDateUnix: Int?,
    @Json(name="flight_number")
    val flightNumber: Int?,
    val details: String?,
    val links: Links?
)
