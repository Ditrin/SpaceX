package com.example.spacexlist.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    val article: String,
    val reddit: Any,
    val wikipedia: String
)

