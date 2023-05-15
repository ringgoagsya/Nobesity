package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.databinding.ActivityMainBinding
import com.dicoding.gizi.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.menu1.setOnClickListener {
            val intent = Intent(this, Menu1Activity::class.java)
            startActivity(intent)
        }
        binding.menu2.setOnClickListener {
            val intent = Intent(this, Menu2Activity::class.java)
            startActivity(intent)
        }
        binding.menu3.setOnClickListener {
            val intent = Intent(this, Menu3Activity::class.java)
            startActivity(intent)
        }
        binding.menu4.setOnClickListener {
            val intent = Intent(this, Menu4Activity::class.java)
            startActivity(intent)
        }
        binding.menu5.setOnClickListener {
            val intent = Intent(this, Menu5Activity::class.java)
            startActivity(intent)
        }
        binding.next.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }
    }
}