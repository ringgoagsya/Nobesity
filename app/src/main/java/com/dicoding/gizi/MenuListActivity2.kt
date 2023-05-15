package com.dicoding.gizi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.gizi.MenuListActivity2.Companion.EXTRA_TITLE
import com.dicoding.gizi.databinding.ActivityMenuList2Binding
import com.dicoding.gizi.databinding.ActivityMenuListBinding
import com.dicoding.gizi.quiz.Quiz1Activity
import com.dicoding.gizi.quiz.Quiz1Activity.Companion.EXTRA_TITLE

class MenuListActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMenuList2Binding
    private var nilai: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuList2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.menu11.setOnClickListener {
            nilai = 0
            val intent = Intent(this, Quiz1Activity::class.java)
            intent.putExtra(Quiz1Activity.EXTRA_TITLE, nilai)
            startActivity(intent)
        }
        binding.menu12.setOnClickListener {
            val intent = Intent(this, Menu12Activity::class.java)
            startActivity(intent)
        }
        binding.menu13.setOnClickListener {
            val intent = Intent(this, Menu13Activity::class.java)
            startActivity(intent)
        }
        binding.about.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }
    }
    companion object {
        const val EXTRA_TITLE = 0
    }
}