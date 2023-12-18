package com.example.spacexlist.domain

interface Mapper<I,O> {
    fun map(event: I): O
}