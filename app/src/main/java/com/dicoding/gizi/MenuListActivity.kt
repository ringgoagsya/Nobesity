package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.databinding.ActivityMenuBinding
import com.dicoding.gizi.databinding.ActivityMenuListBinding

class MenuListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)
        binding = ActivityMenuListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.menu6.setOnClickListener {
            val intent = Intent(this, Menu6Activity::class.java)
            startActivity(intent)
        }
        binding.menu7.setOnClickListener {
            val intent = Intent(this, Menu7Activity::class.java)
            startActivity(intent)
        }
        binding.menu8.setOnClickListener {
            val intent = Intent(this, Menu8Activity::class.java)
            startActivity(intent)
        }
        binding.menu9.setOnClickListener {
            val intent = Intent(this, Menu9Activity::class.java)
            startActivity(intent)
        }
        binding.menu10.setOnClickListener {
            val intent = Intent(this, Menu10Activity::class.java)
            startActivity(intent)
        }
        binding.back.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        binding.next.setOnClickListener {
            val intent = Intent(this, MenuListActivity2::class.java)
            startActivity(intent)
        }
    }
}