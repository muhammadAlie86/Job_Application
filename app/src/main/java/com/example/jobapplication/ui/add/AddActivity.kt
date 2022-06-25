package com.example.jobapplication.ui.add

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
import com.example.jobapplication.databinding.ActivityAddBinding
import com.example.jobapplication.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class AddActivity : AppCompatActivity() {

    private var _binding: ActivityAddBinding? = null
    private val binding get() = _binding!!



    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel : AddViewModel
    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.apply {
            title = "Tambah"
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddViewModel::class.java)

        binding.btnRegister.setOnClickListener {
           createJob()
            createUserObservable()
            moveToMain()
        }
    }
    private fun createJob(){
        val jobName = binding.edJobTypes.text.toString()
        val job = Job(
            UUID.randomUUID().toString(),
            jobName,
            false,
            System.currentTimeMillis().toString(),
            "xxxx",
            System.currentTimeMillis().toString(),
            "Active"
        )
        viewModel.createJob(job)
    }
    private fun moveToMain(){
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun createUserObservable(){
        viewModel.getCreatedJobLiveData().observe(this) { job ->
            if (job != null) {
                Toast.makeText(this, "create job success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "create job success", Toast.LENGTH_SHORT).show()
            }
        }
    }
}