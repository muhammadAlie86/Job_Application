package com.example.jobapplication.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jobapplication.data.model.Job
import com.example.jobapplication.ui.detail.DetailActivity
import com.example.jobapplication.ui.detail.DetailActivity.Companion.EXTRA_DATA
import com.example.jobapplication.ui.edit.EditActivity
import com.example.jobapplication.ui.edit.EditActivity.Companion.JOB_ID
import com.example.jobapplication.databinding.ListJobBinding

class MainAdapter (private val context: Context): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var listJob : ArrayList<Job> = ArrayList()

    fun setJob(job : List<Job>){
        listJob.apply {
            clear()
            addAll(job)
        }

    }
    inner class ViewHolder (private val binding: ListJobBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(job: Job){
            with(binding){
                tvJob.text = job.jotName
                tvEdit.setOnClickListener {
                    val intent = Intent(context, EditActivity::class.java)
                    intent.putExtra(JOB_ID,job.jotID)
                    intent.putExtra(EXTRA_DATA,job)
                    context.startActivity(intent)

                }
                tvJob.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(JOB_ID,job.jotID)
                    intent.putExtra(EXTRA_DATA,job)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listJobBinding = ListJobBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(listJobBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listJob[position])

    }

    override fun getItemCount(): Int = listJob.size
}