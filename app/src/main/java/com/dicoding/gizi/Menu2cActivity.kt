package com.dicoding.gizi

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.gizi.databinding.ActivityMenu2bBinding
import com.dicoding.gizi.databinding.ActivityMenu2cBinding

class Menu2cActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2c)
        var binding = ActivityMenu2cBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            val intent = Intent(this, Menu2bActivity::class.java)
            startActivity(intent)
        }

        binding.next.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }

    }
}