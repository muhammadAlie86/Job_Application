package com.example.jobapplication.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.jobapplication.data.api.RetrofitInstance
import com.example.jobapplication.data.model.Job
import com.example.jobapplication.data.model.JobResponse
import com.example.jobapplication.data.model.User
import com.example.jobapplication.data.model.UserResponse
import com.example.jobapplication.data.source.RemoteDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JobRepository (private val remoteDataSource: RemoteDataSource){

    private var listJobMutableLiveData : MutableLiveData<JobResponse> = MutableLiveData()
    private var createUserMutableLiveData : MutableLiveData<UserResponse> = MutableLiveData()
    private var updateJobMutableLiveData : MutableLiveData<JobResponse> = MutableLiveData()
    private var createJobMutableLiveData : MutableLiveData<JobResponse> = MutableLiveData()
    private var jobMutableLiveData : MutableLiveData<JobResponse> = MutableLiveData()

    //updateJob

    fun getUpdateMutableliveData() : MutableLiveData<JobResponse>{
        return updateJobMutableLiveData
    }
    fun updateJob(jobID : String,job: Job){
        val call = remoteDataSource.updateJob(jobID,job)
        call.enqueue(object : Callback<JobResponse>{
            override fun onResponse(call: Call<JobResponse>, response: Response<JobResponse>) {
                if(response.isSuccessful){
                    updateJobMutableLiveData.postValue(response.body())
                }else{
                    updateJobMutableLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<JobResponse>, t: Throwable) {
                updateJobMutableLiveData.postValue(null)
            }

        })
    }
    //job by id

    fun getJobByIdMutableliveData() : MutableLiveData<JobResponse>{
        return jobMutableLiveData
    }
    fun getJobById(jobID : String){
        val call = remoteDataSource.getJobById(jobID)
        call.enqueue(object : Callback<JobResponse>{
            override fun onResponse(call: Call<JobResponse>, response: Response<JobResponse>) {
                if(response.isSuccessful){
                    jobMutableLiveData.postValue(response.body())
                }else{
                    jobMutableLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<JobResponse>, t: Throwable) {
                jobMutableLiveData.postValue(null)
            }

        })
    }
    //get list job

    fun getListJobMutableliveData() : MutableLiveData<JobResponse>{
        return listJobMutableLiveData
    }
    fun getJobList(){
        val call = remoteDataSource.getAllJob()
        call.enqueue(object : Callback<JobResponse> {
            override fun onResponse(call: Call<JobResponse>, response: Response<JobResponse>) {
                if(response.isSuccessful){
                    listJobMutableLiveData.postValue(response.body())
                }else{
                    listJobMutableLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<JobResponse>, t: Throwable) {
                listJobMutableLiveData.postValue(null)
            }

        })
    }


    //create user
    fun getCreatedUserMutableLiveData() : MutableLiveData<UserResponse>{
        return createUserMutableLiveData
    }
    fun createUser(user : User){
        val call = remoteDataSource.createUser(user)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    createUserMutableLiveData.postValue(response.body())
                }else{
                    createUserMutableLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                createUserMutableLiveData.postValue(null)
            }

        })
    }
    fun getCreatedJobMutableLiveData() : MutableLiveData<JobResponse>{
        return createJobMutableLiveData
    }
    fun createJob(job: Job){
        val call = remoteDataSource.createJobTypes(job)
        call.enqueue(object : Callback<JobResponse> {
            override fun onResponse(call: Call<JobResponse>, response: Response<JobResponse>) {
                if(response.isSuccessful){
                    createJobMutableLiveData.postValue(response.body())
                }else{
                    createUserMutableLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<JobResponse>, t: Throwable) {
                createUserMutableLiveData.postValue(null)
            }

        })
    }
    companion object {

        @Volatile
        private var instance: JobRepository? = null
        fun getInstance(
            remoteDataSource: RemoteDataSource
        ): JobRepository =
            instance ?: synchronized(this) {
                instance ?: JobRepository(remoteDataSource)
            }
    }
}