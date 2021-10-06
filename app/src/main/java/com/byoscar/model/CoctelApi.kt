package com.byoscar.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoctelApi {

    @GET("search.php")
    fun getCoctelesList(@Query("f")letter : Char): Call<CoctelesResponse>

   @GET("random.php")
   fun getCoctelesRamdon(): Call<CoctelesResponse>

}