package com.dicoding.gizi

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.gizi.databinding.ActivityMenu12bBinding
import java.text.NumberFormat

class Menu12bActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenu12bBinding
    private var rentang: String? = null
    private var giziText: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenu12bBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(EXTRA_TITLE)
        binding.IMT.text = title
        playAnimation()
        binding.back.setOnClickListener {
            val intent = Intent(this, Menu12Activity::class.java)
            intent.putExtra(Menu12Activity.EXTRA_TITLE, title)
            startActivity(intent)
        }
        binding.next.setOnClickListener {
            val intent = Intent(this, MenuListActivity2::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            var age = binding.ageTahun.text.toString().trim()
            var agebulan = binding.ageBulan.text.toString().trim()
            var gender = binding.gender.checkedRadioButtonId
            var kelamin = "Laki - Laki"
            val titled = intent.getStringExtra(EXTRA_TITLE)

            kelamin = when (gender) {
                binding.male.id -> {
                    binding.male.text.toString()
                }
                binding.female.id -> {
                    binding.female.text.toString()
                }
                else -> {
                    "Unknown"
                }
            }
            validateUI(age,agebulan,kelamin,titled)
        }
    }
    private fun playAnimation() {
        val title = ObjectAnimator.ofFloat(binding.JKtext, View.ALPHA, 1f).setDuration(500)
        val edtName = ObjectAnimator.ofFloat(binding.bgmenu1, View.ALPHA, 1f).setDuration(500)
        val tvFName = ObjectAnimator.ofFloat(binding.gender, View.ALPHA, 1f).setDuration(500)
        val edtFName = ObjectAnimator.ofFloat(binding.male, View.ALPHA, 1f).setDuration(500)
        val tvName = ObjectAnimator.ofFloat(binding.female, View.ALPHA, 1f).setDuration(500)
        val tvPhone = ObjectAnimator.ofFloat(binding.Umurtext, View.ALPHA, 1f).setDuration(500)
        val edtPhone = ObjectAnimator.ofFloat(binding.bgmenu2, View.ALPHA, 1f).setDuration(500)
        val tvEmail = ObjectAnimator.ofFloat(binding.ageTahun, View.ALPHA, 1f).setDuration(500)
        val input = ObjectAnimator.ofFloat(binding.input, View.ALPHA, 1f).setDuration(500)
        val edtEmail = ObjectAnimator.ofFloat(binding.tahuntext, View.ALPHA, 1f).setDuration(500)
        val tvPassword = ObjectAnimator.ofFloat(binding.ageBulan, View.ALPHA, 1f).setDuration(500)
        val inputnya = ObjectAnimator.ofFloat(binding.inputnya, View.ALPHA, 1f).setDuration(500)
        val edtPassword = ObjectAnimator.ofFloat(binding.textbulan, View.ALPHA, 1f).setDuration(500)
        val btnSignup = ObjectAnimator.ofFloat(binding.button2, View.ALPHA, 1f).setDuration(500)
        val gizi = ObjectAnimator.ofFloat(binding.gizitext, View.ALPHA, 1f).setDuration(500)
        val gizitext = ObjectAnimator.ofFloat(binding.gizi, View.ALPHA, 1f).setDuration(500)
        val next = ObjectAnimator.ofFloat(binding.next, View.ALPHA, 1f).setDuration(500)
        AnimatorSet().apply {
            playSequentially(title,tvFName,edtFName,tvName,edtName,tvPhone,edtPhone, tvEmail,input, edtEmail, tvPassword,inputnya, edtPassword, btnSignup,gizi,gizitext,next)
            start()
        }
    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }


    fun validateUI(age: String?, ageBulan: String?, kelamin: String?, titled: String?) {
        val Age: Int = Integer.parseInt(age)
        val Bulan: Int = Integer.parseInt(ageBulan)
        val Gender:String = kelamin.toString()
        val f: NumberFormat = NumberFormat.getInstance()
        val Title: Double? = f.parse(titled).toDouble()
        Log.d(ContentValues.TAG,"Jenis Kelamin : $Gender  Umur Tahun : $Age Umur Bulan : $Bulan ")
        if (Age < 15) {
            Toast.makeText(this, "Usia tidak boleh kurang dari 15 Tahun ", Toast.LENGTH_SHORT).show()
            if(Title!! > 0 && Title!! <=18.5){
                rentang = "-3SD sampai -2SD"
                giziText = "Gizi Kurang"
            }
            if(Title!! > 18.5 && Title!! <=25){
                rentang = "-2SD sampai +1SD"
                giziText = "Gizi Baik"
            }
            if(Title!! > 25 && Title!! <=29.99){
                rentang = "+1SD sampai +2SD"
                giziText = "Gizi Lebih"
            }
            if(Title!! > 29.99){
                rentang = "> +2SD"
                giziText = "Obesitas"
            }
        } else if (Age <=18) {
            if(Gender == "Perempuan"){
                if(Age == 15){
                    if(Bulan == 0 ){
                        if(Title!! > 0 && Title!! <=15.9){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 15.9 && Title!! <=23.5){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.5 && Title!! <=28.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 1){
                        if(Title!! > 0 && Title!! <=15.9){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 15.9 && Title!! <=23.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.6 && Title!! <=28.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 2){
                        if(Title!! > 0 && Title!! <=15.9){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 15.9 && Title!! <=23.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.5 && Title!! <=28.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 3){
                        if(Title!! > 0 && Title!! <=16){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16 && Title!! <=23.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.5 && Title!! <=28.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 4){
                        if(Title!! > 0 && Title!! <=16){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16 && Title!! <=23.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.7 && Title!! <=28.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }

                    }
                    if(Bulan == 5){
                        if(Title!! > 0 && Title!! <=16){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16 && Title!! <=23.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.8 && Title!! <=28.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 6){
                        if(Title!! > 0 && Title!! <=16){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16 && Title!! <=23.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.8 && Title!! <=28.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 7){
                        if(Title!! > 0 && Title!! <=16.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.1 && Title!! <=23.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.9 && Title!! <=28.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 8){
                        if(Title!! > 0 && Title!! <=16.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.1 && Title!! <=23.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 23.9 && Title!! <=28.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 9){
                        if(Title!! > 0 && Title!! <=16.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.1 && Title!! <=24){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24 && Title!! <=28.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 10){
                        if(Title!! > 0 && Title!! <=16.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.1 && Title!! <=24){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24 && Title!! <=28.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 11){
                        if(Title!! > 0 && Title!! <=16.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.2 && Title!! <=24.1){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.1 && Title!! <=28.8){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.8 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }

                }
                if(Age == 16){
                    if(Bulan == 0){
                        if(Title!! > 0 && Title!! <=16.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.2 && Title!! <=24.1){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.1 && Title!! <=28.9){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.9 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 1){
                        if(Title!! > 0 && Title!! <=16.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.2 && Title!! <=24.1){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.1 && Title!! <=28.9){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.9 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 2){
                        if(Title!! > 0 && Title!! <=16.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.2 && Title!! <=24.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.2 && Title!! <=29){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 3){
                        if(Title!! > 0 && Title!! <=16.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.2 && Title!! <=24.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.2 && Title!! <=29){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 4){
                        if(Title!! > 0 && Title!! <=16.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.2 && Title!! <=24.3){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.3 && Title!! <=29){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 5){
                        if(Title!! > 0 && Title!! <=16.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.2 && Title!! <=24.3){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.3 && Title!! <=29.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 6){
                        if(Title!! > 0 && Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.3 && Title!! <=24.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.4 && Title!! <=29.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 7){
                        if(Title!! > 0 && Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.3 && Title!! <=24.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.4 && Title!! <=29.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 8){
                        if(Title!! > 0 && Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.3 && Title!! <=24.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.4 && Title!! <=29.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 9){
                        if(Title!! > 0 && Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.3 && Title!! <=24.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.4 && Title!! <=29.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 10){
                        if(Title!! > 0 && Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.3 && Title!! <=24.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.4 && Title!! <=29.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 11){
                        if(Title!! > 0 && Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.3 && Title!! <=24.5){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.5 && Title!! <=29.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }

                }
                if(Age == 17){
                    if(Bulan == 0){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.5){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.5 && Title!! <=29.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 1){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.5){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.5 && Title!! <=29.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 2){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.6 && Title!! <=29.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 3){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.6 && Title!! <=29.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 4){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.6 && Title!! <=29.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 5){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.6 && Title!! <=29.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 6){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.6 && Title!! <=29.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 7){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.7 && Title!! <=29.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 8){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.7 && Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 9){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.7 && Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 10){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.7 && Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 11){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.8 && Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }

                }
                if(Age == 18){
                    if(Bulan == 0){
                        if(Title!! > 0 && Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.4 && Title!! <=24.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.8 && Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 1){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.8 && Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 2){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.8 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 3){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.8 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 4){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.8 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 5){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.9 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 6){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.9 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 7){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.9 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 8){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.9 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 9){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.9 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 10){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=24.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.9 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 11){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 16.5 && Title!! <=25){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25 && Title!! <=29.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }

                }
            }
            else if(Gender=="Laki - Laki"){
                if(Age == 15){
                    if(Bulan == 0){
                        if(Title!! <=16){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if( Title!! <=22.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 1){
                        if(Title!! <=16.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=22.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 2){
                        if(Title!! <=16.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=22.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 3){
                        if(Title!! <=16.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if( Title!! <=22.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 4){
                        if( Title!! <=16.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 5){
                        if(Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 6){
                        if(Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.1){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 7){
                        if(Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 8){
                        if(Title!! <=16.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.3){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 9){
                        if(Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.3){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 10){
                        if(Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 11){
                        if(Title!! <=16.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.5){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.8){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.8 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }

                }
                else if(Age == 16){
                    if(Bulan == 0){
                        if(Title!! > 0 && Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.5){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.9){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.9 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 1){
                        if(Title!! <=16.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=27.9){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 27.9 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 2){
                        if(Title!! <=16.6){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 3){
                        if(Title!! > 0 && Title!! <=16.6){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 4){
                        if(Title!! <=16.7){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 5){
                        if(Title!! <=16.7){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 6){
                        if(Title!! <=16.7){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=23.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 7){
                        if(Title!! <=16.8){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 8){
                        if(Title!! <=16.8){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 28.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 9){
                        if(Title!! <=16.8){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.1){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 10){
                        if(Title!! <=16.9){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 11){
                        if(Title!! <=16.9){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }

                }
                else if(Age == 17){
                    if(Bulan == 0){
                        if(Title!! <=16.9){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 1){
                        if(Title!! <=17){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.3){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 2){
                        if(Title!! <=17){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 3){
                        if(Title!! <=17){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.7 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 4){
                        if(Title!! <=17.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.5){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.9){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.9 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 5){
                        if(Title!! <=17.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.5){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=28.9){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 28.9 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 6){
                        if(Title!! <=17.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.6){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=29){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 29 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 7){
                        if(Title!! <=17.1){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=29){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 29 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 8){
                        if(Title!! <=17.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.7){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=29.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 29.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 9){
                        if(Title!! > 0 && Title!! <=17.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=29.1){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 29.1 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 10){
                        if(Title!! <=17.2){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.8){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=29.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 29.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    else if(Bulan == 11){
                        if(Title!! <=17.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        else if(Title!! <=24.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        else if(Title!! <=29.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        else if(Title!! > 29.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }

                }
                else if(Age == 18){
                    if(Bulan == 0){
                        if(Title!! > 0 && Title!! <=17.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.3 && Title!! <=24.9){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 24.9 && Title!! <=29.2){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.2 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 1){
                        if(Title!! > 0 && Title!! <=17.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.3 && Title!! <=25){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25 && Title!! <=29.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 2){
                        if(Title!! > 0 && Title!! <=17.3){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.3 && Title!! <=25){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25 && Title!! <=29.3){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.3 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 3){
                        if(Title!! > 0 && Title!! <=17.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.4 && Title!! <=25.1){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.1 && Title!! <=29.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 4){
                        if(Title!! > 0 && Title!! <=17.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.4 && Title!! <=25.1){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.1 && Title!! <=29.4){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.4 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 5){
                        if(Title!! > 0 && Title!! <=17.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.4 && Title!! <=25.1){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.1 && Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 6){
                        if(Title!! > 0 && Title!! <=17.4){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.4 && Title!! <=25.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.2 && Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 7){
                        if(Title!! > 0 && Title!! <=17.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.5 && Title!! <=25.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.2&& Title!! <=29.5){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.5 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 8){
                        if(Title!! > 0 && Title!! <=17.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.5 && Title!! <=25.2){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.2 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6 ){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 9){
                        if(Title!! > 0 && Title!! <=17.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.5 && Title!! <=25.3){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.3 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 10){
                        if(Title!! > 0 && Title!! <=17.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.5 && Title!! <=25.3){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.3 && Title!! <=29.6){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.6){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }
                    if(Bulan == 11){
                        if(Title!! > 0 && Title!! <=17.5){
                            rentang = "-3SD sampai -2SD"
                            giziText = "Gizi Kurang"
                        }
                        if(Title!! > 17.5 && Title!! <=25.4){
                            rentang = "-2SD sampai +1SD"
                            giziText = "Gizi Baik"
                        }
                        if(Title!! > 25.4 && Title!! <=29.7){
                            rentang = "+1SD sampai +2SD"
                            giziText = "Gizi Lebih"
                        }
                        if(Title!! > 29.7){
                            rentang = "> +2SD"
                            giziText = "Obesitas"
                        }
                    }

                }
            }
            else{
                if(Title!! > 0 && Title!! <=18.5){
                    rentang = "-3SD sampai -2SD"
                    giziText = "Gizi Kurang"
                }
                else if(Title!! > 18.5 && Title!! <=25){
                    rentang = "-2SD sampai +1SD"
                    giziText = "Gizi Baik"
                }
                else if(Title!! > 25 && Title!! <=29.99){
                    rentang = "+1SD sampai +2SD"
                    giziText = "Gizi Lebih"
                }
                else if(Title!! > 29.99){
                    rentang = "> +2SD"
                    giziText = "Obesitas"
                }
            }

        }
        else if (Age <=99){
            if(Title!! > 0 && Title!! <=18.5){
                rentang = "-3SD sampai -2SD"
                giziText = "Gizi Kurang"
            }
            else if(Title!! > 18.5 && Title!! <=25){
                rentang = "-2SD sampai +1SD"
                giziText = "Gizi Baik"
            }
            else if(Title!! > 25 && Title!! <=29.99){
                rentang = "+1SD sampai +2SD"
                giziText = "Gizi Lebih"
            }
            else if(Title!! > 29.99){
                rentang = "> +2SD"
                giziText = "Obesitas"
            }
        }
        else if (Age > 100) {
            Toast.makeText(this, "Usia tidak boleh melebihi 100 Tahun", Toast.LENGTH_SHORT).show()
            if(Title!! > 0 && Title!! <=18.5){
                rentang = "-3SD sampai -2SD"
                giziText = "Gizi Kurang"
            }
            if(Title!! > 18.5 && Title!! <=25){
                rentang = "-2SD sampai +1SD"
                giziText = "Gizi Baik"
            }
            if(Title!! > 25 && Title!! <=29.99){
                rentang = "+1SD sampai +2SD"
                giziText = "Gizi Lebih"
            }
            if(Title!! > 29.99){
                rentang = "> +2SD"
                giziText = "Obesitas"
            }
        }
        val statustext = "$rentang \n $giziText \n "
        binding.gizi.text = statustext.toString()

    }
    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val text = "30"
    }
}