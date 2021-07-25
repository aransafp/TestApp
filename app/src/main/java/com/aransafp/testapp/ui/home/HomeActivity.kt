package com.aransafp.testapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aransafp.testapp.R
import com.aransafp.testapp.databinding.ActivityHomeBinding
import com.aransafp.testapp.ui.event.EventActivity
import com.aransafp.testapp.ui.guest.GuestActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding

    companion object {
        const val EXTRA_NAME = "extra_name"

        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        binding.tvName.text = name

        binding.btnEvent.setOnClickListener(this)
        binding.btnGuest.setOnClickListener(this)

        supportActionBar?.title = "Home"
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.btn_event -> {
                val intent = Intent(this@HomeActivity, EventActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE)
            }

            R.id.btn_guest -> {
                val intent = Intent(this@HomeActivity, GuestActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == EventActivity.RESULT_CODE) {
                val eventTitle = data?.getStringExtra(EventActivity.RESULT_EVENT)
                binding.btnEvent.text = eventTitle
            } else if (resultCode == GuestActivity.RESULT_CODE) {
                val guestName = data?.getStringExtra(GuestActivity.RESULT_GUEST)
                binding.btnGuest.text = guestName
            }

        }
    }
}