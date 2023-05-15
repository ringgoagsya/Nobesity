package com.dicoding.gizi

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.gizi.Menu12Activity.Companion.EXTRA_TITLE
import com.dicoding.gizi.databinding.ActivityMenu12Binding


class Menu12Activity : AppCompatActivity() {
    private var text: String? = null
    private lateinit var binding: ActivityMenu12Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenu12Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val berat = binding.weight.text
        val tinggi= binding.height.text

        binding.back.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }

        binding.button1.setOnClickListener {
            var bb : String = berat.toString()
            var ti : String = tinggi.toString()
            var beratku = bb.toFloat()
            var tinggiku = ti.toFloat()/100
            Log.d(TAG,"berat : $beratku tinggi: $tinggiku")
            var imt = (beratku) / (tinggiku * tinggiku)
            Log.d(TAG,"imt $imt")
            text = String.format("%.2f",imt)
            binding.IMT.text = text.toString()


        }
        binding.next.setOnClickListener {
            val intent = Intent(this, Menu12bActivity::class.java)
            intent.putExtra(Menu12bActivity.EXTRA_TITLE, text)
            startActivity(intent)
        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }


    fun validateUI(age: String?, kelamin: String?) {
        val Age: Int = Integer.parseInt(age)
        val Gender:String = kelamin.toString()
        Log.d(TAG,"Jenis Kelamin : $Gender  Umur : $Age")
        if (Age < 10) {
            Toast.makeText(this, "Usia tidak boleh kurang dari 10 Tahun ", Toast.LENGTH_SHORT).show()
        } else if (Age > 100) {
            Toast.makeText(this, "Usia tidak boleh melebihi 100 Tahun", Toast.LENGTH_SHORT).show()
        } else {
            if(Gender == "Perempuan"){
                Toast.makeText(this@Menu12Activity, Gender, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@Menu12Activity, Gender, Toast.LENGTH_SHORT).show()

            }

        }
    }
    companion object {
        const val EXTRA_TITLE = "extra_title"
    }


}