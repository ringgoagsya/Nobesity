package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.databinding.ActivityMenu2bBinding
import com.dicoding.gizi.databinding.ActivityMenu6Binding

class Menu6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMenu6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }
    }
}