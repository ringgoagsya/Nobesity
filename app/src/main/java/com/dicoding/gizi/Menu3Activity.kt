package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.databinding.ActivityMenu2bBinding
import com.dicoding.gizi.databinding.ActivityMenu3Binding

class Menu3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu3)
        var binding = ActivityMenu3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        binding.next.setOnClickListener {
            val intent = Intent(this, Menu2aActivity::class.java)
            startActivity(intent)
        }
    }
}