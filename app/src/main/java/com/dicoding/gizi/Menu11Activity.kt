package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dicoding.gizi.databinding.ActivityMenu11Binding
import com.dicoding.gizi.databinding.ActivityMenu2bBinding
import com.dicoding.gizi.databinding.ActivityMenu9Binding
import com.dicoding.gizi.quiz.Quiz10Activity

class Menu11Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMenu11Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var nilai = intent.getIntExtra(Quiz10Activity.EXTRA_TITLE,0)
        binding.textpring.text =nilai.toString()
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, MenuListActivity2::class.java).apply {
                startActivity(this)
            }
            finish()
        }, 3000.toLong())
    }
    companion object {
        const val EXTRA_TITLE = "10"
    }
}