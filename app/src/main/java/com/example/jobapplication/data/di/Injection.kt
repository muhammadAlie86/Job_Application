package com.example.jobapplication.data.di

import android.content.Context
import com.example.jobapplication.data.repository.JobRepository
import com.example.jobapplication.data.repository.JobRepository.Companion.getInstance
import com.example.jobapplication.data.source.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): JobRepository {

        val remoteDataSource = RemoteDataSource.getInstance()


        return JobRepository.getInstance(remoteDataSource)
    }
}