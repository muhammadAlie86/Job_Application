package com.example.jobapplication.ui.edit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobapplication.data.model.Job
import com.example.jobapplication.data.model.JobResponse
import com.example.jobapplication.data.repository.JobRepository

class EditViewModel (private val repository: JobRepository) : ViewModel(){

    private val updateJobLiveData : MutableLiveData<JobResponse> = repository.getUpdateMutableliveData()

    fun updateJob(jobID : String,job: Job){
        repository.updateJob(jobID,job)
    }
    fun getUpdateLiveData() : MutableLiveData<JobResponse>{
        return updateJobLiveData
    }
}