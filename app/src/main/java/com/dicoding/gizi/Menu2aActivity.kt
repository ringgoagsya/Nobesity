package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.databinding.ActivityMainBinding
import com.dicoding.gizi.databinding.ActivityMenu2aBinding

class Menu2aActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenu2aBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenu2aBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            val intent = Intent(this, Menu2Activity::class.java)
            startActivity(intent)
        }
        binding.next.setOnClickListener {
            val intent = Intent(this, Menu2bActivity::class.java)
            startActivity(intent)
        }
    }
}