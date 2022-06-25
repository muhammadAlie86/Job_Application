package com.example.jobapplication.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobapplication.data.model.JobResponse
import com.example.jobapplication.data.repository.JobRepository

class DetailViewModel (private val repository: JobRepository) : ViewModel() {

    private val detailJobLiveData : MutableLiveData<JobResponse> = repository.getJobByIdMutableliveData()

    fun getJobById(jobID : String){
        repository.getJobById(jobID)
    }
    fun getJobByIdLiveData() : MutableLiveData<JobResponse> {
        return detailJobLiveData
    }
}