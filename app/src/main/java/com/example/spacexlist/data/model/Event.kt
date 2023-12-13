package com.example.spacexlist.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Event(
    val id: Int,
    val title: String?,
    val event_date_utc: String,
    val event_date_unix: Int,
    val flight_number: Int,
    val details: String,
    val links: Links
)
