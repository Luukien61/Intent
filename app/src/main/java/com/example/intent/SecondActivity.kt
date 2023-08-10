package com.example.intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMainBinding
import com.example.intent.databinding.ActivitySecondBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivitySecondBinding
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent= intent
        val name = intent.getStringExtra("username")
        setaccount(name)
    }

    private fun setaccount(name: String?) {
           binding.txtusername.setText(name)
    }
}