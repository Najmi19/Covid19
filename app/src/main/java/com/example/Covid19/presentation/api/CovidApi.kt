package com.example.Covid19.presentation.api

import com.example.Covid19.presentation.detail.CovidDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CovidApi {

    @GET("countries")
    fun getCovidList(): Call<List<CovidListResponse>>

    @GET("country/{id}")
    fun getCovidDetail(@Path("id") id:String): Call<List<CovidDetailResponse>>

}

