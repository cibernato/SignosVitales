package com.uancv.signosvitales.models

import com.google.gson.annotations.SerializedName

data class RefreshToken(
    @SerializedName("RefreshToken")
    var RefreshToken: String? = null,
    @SerializedName("AccessToken")
    var AccessToken: String? = null,
    @SerializedName("IdModulo")
    var IdModulo: Int? = 0
) {
}