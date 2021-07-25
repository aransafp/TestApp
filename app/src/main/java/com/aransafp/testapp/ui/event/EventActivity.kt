package com.aransafp.testapp.ui.event

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aransafp.testapp.R
import com.aransafp.testapp.databinding.ActivityEventBinding
import com.aransafp.testapp.ui.map.MapFragment


class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    companion object {
        const val RESULT_CODE = 110
        const val RESULT_EVENT = "result_event"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showEventFragment()

        supportActionBar?.title = "List Event"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.menu2 -> {
                Toast.makeText(this, "Open Map", Toast.LENGTH_SHORT).show()
                showMapFragment()
            }
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showEventFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, EventFragment())
            .commit()
    }

    private fun showMapFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, MapFragment())
            .addToBackStack(null)
            .commit()
    }
}