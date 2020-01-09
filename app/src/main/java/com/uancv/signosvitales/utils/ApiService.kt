package com.uancv.signosvitales.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    var token = ""

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://desarrollo.sreasons.com/MSSeguridad/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor { chain ->
            val request =
                chain.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
            chain.proceed(request)
        }.build())
        .build()

    var service: AppAPI = retrofit.create(AppAPI::class.java)
        private set

}