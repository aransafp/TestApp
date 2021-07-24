package com.aransafp.testapp.event

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aransafp.testapp.data.dummy.DataDummy
import com.aransafp.testapp.databinding.ActivityEventBinding
import com.aransafp.testapp.home.HomeActivity

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

        adapter.setOnItemClickCallback(object: EventAdapter.OnItemClickCallback{
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
}