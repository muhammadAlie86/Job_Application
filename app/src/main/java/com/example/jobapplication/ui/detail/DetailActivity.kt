package com.example.jobapplication.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jobapplication.R
import com.example.jobapplication.data.ViewModelFactory
import com.example.jobapplication.data.model.Job
import com.example.jobapplication.databinding.ActivityDetailBinding
import com.example.jobapplication.ui.main.MainActivity

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.apply {
            title = "Detail Job"
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        getJobByIdObservable()
        val jobID = intent.getStringExtra(JOB_ID)
        val job = intent.getParcelableExtra<Job>(EXTRA_DATA)
        if (jobID != null) {
            viewModel.getJobById(jobID)
            getDetail(job)
        }
    }

    private fun getDetail(job: Job?) {
        if (job != null){
            binding.tvJob.text = job.jotName
        }


    }

    private fun getJobByIdObservable() {
        viewModel.getJobByIdLiveData().observe(this) { job ->
            if (job != null) {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val JOB_ID = "jobId"
    }
}