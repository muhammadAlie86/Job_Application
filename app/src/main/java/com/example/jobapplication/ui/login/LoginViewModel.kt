package com.example.jobapplication.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobapplication.data.model.User
import com.example.jobapplication.data.model.UserResponse
import com.example.jobapplication.data.repository.JobRepository

class LoginViewModel (private val repository: JobRepository): ViewModel() {

    var createUserLiveData : MutableLiveData<UserResponse>

    init {
        createUserLiveData = repository.getCreatedUserMutableLiveData()
    }
    fun createUser(user : User){
        repository.createUser(user)
    }
    fun getCreatedUserLiveData() : MutableLiveData<UserResponse>{
        return createUserLiveData
    }
}