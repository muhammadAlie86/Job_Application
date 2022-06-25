package com.example.jobapplication.data.model

import com.google.gson.annotations.SerializedName

data class JobResponse(

    @SerializedName("data")
    val items : List<Job>
)
