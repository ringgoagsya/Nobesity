package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.databinding.ActivityMenu8Binding
import com.dicoding.gizi.databinding.ActivityMenu8aBinding

class Menu8aActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMenu8aBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            val intent = Intent(this, Menu9Activity::class.java)
            startActivity(intent)
        }
        binding.next.setOnClickListener {
            val intent = Intent(this, Menu8bActivity::class.java)
            startActivity(intent)
        }
    }
}