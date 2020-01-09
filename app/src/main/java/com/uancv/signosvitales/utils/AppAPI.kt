package com.uancv.signosvitales.utils

import com.uancv.signosvitales.models.RefreshToken
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AppAPI {

    @POST("api/usuarios/refreshtoken")
    fun searchArtist(@Body token: RefreshToken): Call<RefreshToken>

}