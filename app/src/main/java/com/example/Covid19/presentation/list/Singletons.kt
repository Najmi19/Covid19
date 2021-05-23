package com.example.Covid19.presentation.list

import com.example.Covid19.presentation.CovidApplication.Companion.context
import com.example.Covid19.presentation.api.CovidApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object{
        var cache = Cache(File(context?.cacheDir, "responses"), 10*1024*1024)

        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val covidApi: CovidApi = Retrofit.Builder()
            .baseUrl("https://api.covid19api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CovidApi::class.java)
    }

}

