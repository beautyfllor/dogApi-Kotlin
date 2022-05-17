package com.example.dogapi.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {
    @GET("/api/breed/{raca}/images/random")
    fun getDog(@Path(value="raca") raca : String): Call<JsonObject>
}