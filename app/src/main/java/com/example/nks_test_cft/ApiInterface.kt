package com.example.cft_test_nks

import InformDataClass
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {
    @GET("bin")
    fun getInformDataClass(@Query("bin") bin: String): Call<InformDataClass>

   // @GET("/{id}")
    //fun getInformDataClass(@Path("id") bin: Int): Call<InformDataClass>



    companion object {

        var BASE_URL = "https://lookup.binlist.net/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}