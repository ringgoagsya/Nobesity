package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.databinding.ActivityAboutBinding
import com.dicoding.gizi.databinding.ActivityReferenceBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.next.setOnClickListener {
            val intent = Intent(this, ReferenceActivity::class.java)
            startActivity(intent)
        }
        binding.bgmenu2.setOnClickListener {
            val intent = Intent(this, ReferenceActivity::class.java)
            startActivity(intent)
        }
        binding.back.setOnClickListener {
            val intent = Intent(this, MenuListActivity2::class.java)
            startActivity(intent)
        }
    }
}