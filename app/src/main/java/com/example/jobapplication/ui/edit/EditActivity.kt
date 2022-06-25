package com.example.jobapplication.ui.edit

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jobapplication.R
import com.example.jobapplication.data.ViewModelFactory
import com.example.jobapplication.data.model.Job
import com.example.jobapplication.databinding.ActivityEditBinding
import com.example.jobapplication.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {

    private var _binding: ActivityEditBinding? = null
    private val binding get() = _binding!!



    private val activityScope = CoroutineScope(Dispatchers.Main)
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel : EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.apply {
            title = "Edit Job"
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(EditViewModel::class.java)

        binding.btnEdit.setOnClickListener {
            editJob()
            editJobObservable()
            moveToMain()
        }
    }
    private fun moveToMain(){
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun editJob(){
        val jobID = intent.getStringExtra(JOB_ID)
        val jobName = binding.edEdit.text.toString()
        if (jobID != null) {
            val job = Job(
                jobID,
                jobName,
                false,
                "",
                "",
                System.currentTimeMillis().toString(),
                "Active")
            viewModel.updateJob(jobID, job)
        }
    }
    private fun editJobObservable(){
        viewModel.getUpdateLiveData().observe(this) { job ->
            if (job != null) {
                Toast.makeText(this, "edit job success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "edit job success", Toast.LENGTH_SHORT).show()
            }
        }
    }
    companion object{
        const val JOB_ID = "jobId"
    }
}