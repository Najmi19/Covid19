package com.example.Covid19.presentation.detail

data class CovidDetailResponse (
        val Country: String,
        val Confirmed: Int,
        val Deaths: Int,
        val Recovered: Int,
        val Active: Int,
        val Date: String
)