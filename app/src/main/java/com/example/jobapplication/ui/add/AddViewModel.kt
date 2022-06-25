package com.example.jobapplication.ui.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobapplication.data.model.Job
import com.example.jobapplication.data.model.JobResponse
import com.example.jobapplication.data.repository.JobRepository

class AddViewModel (private val repository: JobRepository): ViewModel() {

    private var createJobLiveData : MutableLiveData<JobResponse> = repository.getCreatedJobMutableLiveData()

    fun createJob(job: Job){
        repository.createJob(job)
    }
    fun getCreatedJobLiveData() : MutableLiveData<JobResponse> {
        return createJobLiveData
    }
}