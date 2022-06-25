package com.example.jobapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobapplication.data.model.JobResponse
import com.example.jobapplication.data.repository.JobRepository

class MainViewModel (private val repository : JobRepository): ViewModel(){

    var jobMutableLiveData : MutableLiveData<JobResponse> = repository.getListJobMutableliveData()

    fun getJobList(){
        repository.getJobList()
    }
}