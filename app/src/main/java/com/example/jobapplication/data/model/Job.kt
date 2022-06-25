package com.example.jobapplication.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(

    @SerializedName("jotID")
    var jotID : String,

    @SerializedName("jotName")
    var jotName : String,

    @SerializedName("jotActive")
    var jotActive : Boolean,

    @SerializedName("jotCreatedAt")
    var jotCreatedAt : String,

    @SerializedName("jotUpdatedUsr")
    var jotUpdatedUsr : String,

    @SerializedName("jotUpdatedAt")
    var jotUpdatedAt : String,

    @SerializedName("jotActiveLabel")
    var jotActiveLabel : String
) : Parcelable
