package com.example.jobapplication.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobapplication.R
import com.example.jobapplication.data.ViewModelFactory
import com.example.jobapplication.ui.add.AddActivity
import com.example.jobapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val listJob: MainAdapter by lazy {
        MainAdapter(this)
    }


    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.apply {
            title = "Job App"
        }
        viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getJobList()
        initRecyclerView()

        observe()
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent (this,AddActivity::class.java)
            startActivity(intent)
        }

    }
    private fun observe() {
        viewModel.jobMutableLiveData.observe(this) {
            listJob.setJob(it.items)
            listJob.notifyDataSetChanged()

        }

    }


    private fun initRecyclerView() {

        with(binding.rvTicketCustomer) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = listJob
        }
    }
}