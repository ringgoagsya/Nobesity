package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.databinding.ActivityMenu2bBinding
import com.dicoding.gizi.databinding.ActivityMenu8Binding

class Menu8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMenu8Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }
        binding.next.setOnClickListener {
            val intent = Intent(this, Menu8aActivity::class.java)
            startActivity(intent)
        }
    }
}