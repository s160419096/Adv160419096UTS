package com.ubaya.adv160419096uts.model

import com.google.gson.annotations.SerializedName

data class History(
    val id:String?,
    val title:String?,
    val donasi:String?,
    val hari:String?,
    @SerializedName("total_donasi")
    val totalDonasi:String?,
    @SerializedName("image_url")
    val imageUrl:String?,
    val donasi_user:String?
)