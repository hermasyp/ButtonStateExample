package com.catnip.buttonstateexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.catnip.buttonstateexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
/*
    old implementation...
    private lateinit var flAction1: FrameLayout
    private lateinit var flAction2: FrameLayout
    private lateinit var flAction3: FrameLayout
    private lateinit var tvSelectedButton: TextView
*/
    private lateinit var binding: ActivityMainBinding

    private var selectedButton: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
        setClickListeners()
        showSelectedButton()
    }

    private fun bindViews() {
/*
        Old Implementation
        flAction1 = findViewById(R.id.fl_action_1)
        flAction2 = findViewById(R.id.fl_action_2)
        flAction3 = findViewById(R.id.fl_action_3)
        tvSelectedButton = findViewById(R.id.tv_selected_button)*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setClickListeners() {
        binding.flAction1.setOnClickListener {
            selectedButton = 1
            showSelectedButton()
            binding.flAction1.setBackgroundResource(R.drawable.bg_action_button)
            binding.flAction2.setBackgroundResource(0)
            binding.flAction3.setBackgroundResource(0)
        }
        binding.flAction2.setOnClickListener {
            selectedButton = 2
            showSelectedButton()
            binding.flAction2.setBackgroundResource(R.drawable.bg_action_button)
            binding.flAction1.setBackgroundResource(0)
            binding.flAction3.setBackgroundResource(0)
        }
        binding.flAction3.setOnClickListener {
            selectedButton = 3
            showSelectedButton()
            binding.flAction3.setBackgroundResource(R.drawable.bg_action_button)
            binding.flAction1.setBackgroundResource(0)
            binding.flAction2.setBackgroundResource(0)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showSelectedButton() {
        binding.tvSelectedButton.text = "Nilai Button adalah $selectedButton"
        Log.d(TAG, "showSelectedButton: $selectedButton")
    }

}