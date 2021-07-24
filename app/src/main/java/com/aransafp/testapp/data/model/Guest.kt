package com.aransafp.testapp.data.model

import com.google.gson.annotations.SerializedName

data class Guest(

    @field:SerializedName("birthdate")
    val birthdate: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int
)
