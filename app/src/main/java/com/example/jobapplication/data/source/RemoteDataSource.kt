package com.example.jobapplication.data.source

import com.example.jobapplication.data.api.ApiClient
import com.example.jobapplication.data.api.RetrofitInstance
import com.example.jobapplication.data.model.Job
import com.example.jobapplication.data.model.JobResponse
import com.example.jobapplication.data.model.User
import com.example.jobapplication.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Path

class RemoteDataSource {
    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }
    fun getAllJob() = RetrofitInstance.apiClient.getJobTypes()
    fun createUser(user : User) = RetrofitInstance.apiClient.createUser(user)
    fun createJobTypes(job: Job) = RetrofitInstance.apiClient.createJobTypes(job)
    fun getJobById( jobID : String) = RetrofitInstance.apiClient.getJobById(jobID)
    fun updateJob(jobID : String,job : Job) = RetrofitInstance.apiClient.updateJob(jobID,job)
}