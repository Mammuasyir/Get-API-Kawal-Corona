package com.example.covidapp.api

import com.example.covidapp.model.ResponseGetCoronaItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("indonesia")
    fun getCovidIndonesia() : Call<List<ResponseGetCoronaItem?>?>
}