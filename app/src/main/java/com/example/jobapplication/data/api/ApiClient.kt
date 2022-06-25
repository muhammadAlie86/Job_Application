package com.example.jobapplication.data.api

import com.example.jobapplication.data.model.Job
import com.example.jobapplication.data.model.JobResponse
import com.example.jobapplication.data.model.User
import com.example.jobapplication.data.model.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {

    @GET("job-types")
    fun getJobTypes(): Call<JobResponse>

    @POST("auth/login")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun createUser(@Body params : User) : Call<UserResponse>

    @POST("job-types")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun createJobTypes(@Body params : Job) : Call<JobResponse>

    @GET("job-types/{jobID}")
    @Headers("Accept:application/json,Content-Type:application/json")
    fun getJobById(@Path("jobID") jobID : String) : Call<JobResponse>

    @PUT("job-types/{jobID}")
    @Headers("Accept:application/json,Content-Type:application/json")
    fun updateJob(@Path("jobID") jobID : String,@Body params : Job) : Call<JobResponse>
}