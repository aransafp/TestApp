package com.aransafp.testapp.data.network

import com.aransafp.testapp.data.model.Guest
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("v2/596dec7f0f000023032b8017")
    fun getListGuests(): Call<List<Guest>>

}