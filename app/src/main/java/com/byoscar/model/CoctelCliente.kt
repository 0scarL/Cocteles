package com.byoscar.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CoctelCliente {

    private val URL_BASE = "https://www.thecocktaildb.com/api/json/v1/1/"

    private val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service = retrofit.create(CoctelApi::class.java)
}