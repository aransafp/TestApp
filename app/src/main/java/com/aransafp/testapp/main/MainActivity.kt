package com.aransafp.testapp.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aransafp.testapp.R
import com.aransafp.testapp.databinding.ActivityMainBinding
import com.aransafp.testapp.home.HomeActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener(this)

    }

    private fun moveToHome(name: String) {
        val intent = Intent(this@MainActivity, HomeActivity::class.java)
        intent.putExtra(HomeActivity.EXTRA_NAME, name)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_next) {

            val inputName = binding.edName.text.toString()

            if (inputName.isEmpty()) {
                binding.edName.error = "Jangan kosong"
            } else {
                moveToHome(inputName)
            }

        }
    }

}