package com.intelligence.cleanarchichtecture.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.intelligence.cleanarchichtecture.R
import com.intelligence.cleanarchichtecture.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        userViewModel.isSaveData.observe(this) {
            binding.tvShowData.text = getString(R.string.save_result_label, it)
        }

        userViewModel.userInfoData.observe(this) {
            binding.tvShowData.text = it
        }

        binding.btnGetData.setOnClickListener {
            userViewModel.load()
        }

        binding.btnSaveData.setOnClickListener {
            binding.apply {
                tvShowData.text = null
                userViewModel.save(editFirstName.text.toString(), editLastName.text.toString())

            }
        }

    }

}