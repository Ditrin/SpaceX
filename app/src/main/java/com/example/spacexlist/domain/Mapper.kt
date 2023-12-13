package com.example.spacexlist.domain

interface Mapper<I,O> {
    fun map(t: I): O
}