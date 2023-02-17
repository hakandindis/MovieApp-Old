package org.hakandindis.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("status")
    val status: Status?
)
