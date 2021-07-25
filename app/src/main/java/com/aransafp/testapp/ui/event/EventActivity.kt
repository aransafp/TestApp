package com.aransafp.testapp.ui.event

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aransafp.testapp.R
import com.aransafp.testapp.data.dummy.DataDummy
import com.aransafp.testapp.databinding.ActivityEventBinding
import com.aransafp.testapp.ui.home.HomeActivity
import com.aransafp.testapp.ui.map.MapActivity


class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding
    private lateinit var adapter: EventAdapter

    companion object {
        const val RESULT_CODE = 110
        const val RESULT_EVENT = "result_event"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EventAdapter()
        adapter.setEvent(DataDummy.getListEvent())

        binding.rvEvent.layoutManager = LinearLayoutManager(this)
        binding.rvEvent.adapter = adapter

        adapter.setOnItemClickCallback(object : EventAdapter.OnItemClickCallback {
            override fun onItem(eventName: String) {

                //pass event title to HomeActivity
                val intent = Intent(this@EventActivity, HomeActivity::class.java)
                intent.putExtra(RESULT_EVENT, eventName)
                setResult(RESULT_CODE, intent)
                finish()

            }

        })



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
                startActivity(Intent(this, MapActivity::class.java))
            }
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}