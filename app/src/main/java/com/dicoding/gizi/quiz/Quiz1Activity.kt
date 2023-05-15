package com.dicoding.gizi.quiz

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import com.dicoding.gizi.*
import com.dicoding.gizi.databinding.ActivityMenuListBinding
import com.dicoding.gizi.databinding.ActivityQuiz1Binding

class Quiz1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityQuiz1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz1)
//1. A
//2. B
//3. A
//4. C
//5. D
//6. A
//7. A
//8.A
//9. A
//10. B
        binding = ActivityQuiz1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val get = intent.getIntExtra(EXTRA_TITLE,0)
        Log.d(TAG,"$get")
        binding.bgmenu2.setOnClickListener {
            playAnimationSalah()
        }
        binding.bgmenu3.setOnClickListener {
            playAnimationBenar()
        }
        binding.bgmenu4.setOnClickListener {
            playAnimationSalah()
        }
        binding.bgmenu5.setOnClickListener {
            playAnimationSalah()
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
    private fun playAnimationBenar() {
        val edtName = ObjectAnimator.ofFloat(binding.bgmenu1, View.ALPHA, 0f).setDuration(500)
        val tvFName = ObjectAnimator.ofFloat(binding.bgmenu2, View.ALPHA, 0f).setDuration(500)
        val edtFName = ObjectAnimator.ofFloat(binding.bgmenu3, View.ALPHA, 0f).setDuration(500)
        val tvName = ObjectAnimator.ofFloat(binding.bgmenu4, View.ALPHA, 0f).setDuration(500)
        val tvPhone = ObjectAnimator.ofFloat(binding.bgmenu5, View.ALPHA, 0f).setDuration(500)
        val edtPhone = ObjectAnimator.ofFloat(binding.bgmenu2, View.ALPHA, 0f).setDuration(500)
        val tvEmail = ObjectAnimator.ofFloat(binding.benar, View.ALPHA, 1f).setDuration(500)
        val input = ObjectAnimator.ofFloat(binding.next, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(edtFName,tvFName,tvName,edtName,tvPhone,edtPhone, tvEmail,input)
            start()
        }
        var nilai = intent.getIntExtra(EXTRA_TITLE,0)
        nilai = nilai!! + 10
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, Quiz2Activity::class.java).apply {
                this.putExtra(Quiz2Activity.EXTRA_TITLE, nilai)
                startActivity(this)
            }
            finish()
        }, SPLASH_SCREEN_TIME.toLong())
    }
    private fun playAnimationSalah() {
        val edtName = ObjectAnimator.ofFloat(binding.bgmenu1, View.ALPHA, 0f).setDuration(500)
        val tvFName = ObjectAnimator.ofFloat(binding.bgmenu2, View.ALPHA, 0f).setDuration(500)
        val edtFName = ObjectAnimator.ofFloat(binding.bgmenu3, View.ALPHA, 0f).setDuration(500)
        val tvName = ObjectAnimator.ofFloat(binding.bgmenu4, View.ALPHA, 0f).setDuration(500)
        val tvPhone = ObjectAnimator.ofFloat(binding.bgmenu5, View.ALPHA, 0f).setDuration(500)
        val edtPhone = ObjectAnimator.ofFloat(binding.bgmenu2, View.ALPHA, 0f).setDuration(500)
        val tvEmail = ObjectAnimator.ofFloat(binding.salah, View.ALPHA, 1f).setDuration(500)
        val input = ObjectAnimator.ofFloat(binding.next, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(edtFName,tvFName,tvName,edtName,tvPhone,edtPhone, tvEmail,input)
            start()
        }
        var nilai = intent.getIntExtra(EXTRA_TITLE,0)
        nilai = nilai!! + 0
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, Quiz2Activity::class.java).apply {
                this.putExtra(Quiz2Activity.EXTRA_TITLE, nilai)
                startActivity(this)
            }
            finish()
        }, SPLASH_SCREEN_TIME.toLong())
    }
    companion object {
        const val EXTRA_TITLE = "10"
        const val SPLASH_SCREEN_TIME = "5000"
        var nilai:Int? = 0
    }


}