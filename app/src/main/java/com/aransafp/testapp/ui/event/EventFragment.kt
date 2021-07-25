package com.aransafp.testapp.ui.event

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aransafp.testapp.data.dummy.DataDummy
import com.aransafp.testapp.data.model.Event
import com.aransafp.testapp.databinding.FragmentEventBinding
import com.aransafp.testapp.ui.home.HomeActivity

class EventFragment : Fragment() {

    private lateinit var eventAdapter: EventAdapter

    private var _binding: FragmentEventBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventAdapter = EventAdapter()
        eventAdapter.setEvent(DataDummy.getListEvent())

        initRecyclerView()

        eventAdapter.setOnItemClickCallback(object : EventAdapter.OnItemClickCallback {
            override fun onItem(eventName: Event) {

                //pass event title to HomeActivity
                backToHomeActivity(eventName.name)
            }
        })

    }

    private fun initRecyclerView() {
        with(binding.rvEvent) {
            layoutManager = LinearLayoutManager(activity)
            adapter = eventAdapter
        }

    }

    private fun backToHomeActivity(message: String) {
        if (activity != null) {
            val intent = Intent(activity, HomeActivity::class.java)
            intent.putExtra(EventActivity.RESULT_EVENT, message)
            activity?.setResult(EventActivity.RESULT_CODE, intent)
            activity?.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}