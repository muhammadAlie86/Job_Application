package com.example.jobapplication.ui.login

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jobapplication.R
import com.example.jobapplication.data.ViewModelFactory
import com.example.jobapplication.data.model.User
import com.example.jobapplication.databinding.ActivityRegisterBinding
import com.example.jobapplication.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!


    private val activityScope = CoroutineScope(Dispatchers.Main)

    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel : LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

        binding.btnRegister.setOnClickListener {
            createUser()
            createUserObservable()
            moveToMain()

        }
    }
    private fun createUser(){
        val username = binding.edUser.text.toString()
        val pass = binding.edUser.text.toString()
        val user = User(username,pass)
        viewModel.createUser(user)
    }
    private fun moveToMain(){
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun createUserObservable(){
        viewModel.getCreatedUserLiveData().observe(this) { user ->
            if (user != null) {
                Toast.makeText(this, "create user success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "create user success", Toast.LENGTH_SHORT).show()
            }
        }
    }
}