package com.aransafp.testapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.aransafp.testapp.R
import com.aransafp.testapp.databinding.ActivityMainBinding
import com.aransafp.testapp.helper.Helper
import com.aransafp.testapp.ui.home.HomeActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener(this)

        supportActionBar?.hide()
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
//                moveToHome(inputName)
                showDialog(inputName)
            }

        }
    }


    fun showDialog(name: String) {

        val dialogMessage =
            if (Helper.isPalindrome(name)) R.string.polindrome_true else R.string.polindrome_false

        val alertDialogBuilder = AlertDialog.Builder(this)
        with(alertDialogBuilder) {
            setTitle("check is your name palindrome")
            setMessage(dialogMessage)
            setCancelable(false)
            setPositiveButton("NEXT") { _, _ ->
                moveToHome(name)
            }
            setNegativeButton("BACK") { dialog, _ -> dialog.cancel() }
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}