package com.example.Covid19.image

import com.example.Covid19.presentation.api.CovidListResponse

interface CovidRepository {
    fun getCovidList() : List<CovidListResponse>
}