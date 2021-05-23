package com.example.Covid19.presentation.detail

data class CovidDetailResponse (
        val Country: String,
        val Confirmed: Int,
        val Deaths: Int,
        val Recovered: Int,
        val Active: Int,
        val Province: String,
        val Date: String,
        val TotalConfirmed: Int
)
/*
data class CovidCountry (
    val Confirmed: Int,
    val Deaths: Int,
    val Recovered: Int,
    val Active: Int
)
*/