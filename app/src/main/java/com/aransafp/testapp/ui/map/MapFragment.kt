package com.aransafp.testapp.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aransafp.testapp.R
import com.aransafp.testapp.data.dummy.DataDummy
import com.aransafp.testapp.data.model.Event
import com.aransafp.testapp.databinding.FragmentMapBinding
import com.aransafp.testapp.ui.event.EventAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var eventAdapter: EventAdapter
    var lat: Double = 1.0
    var lng: Double = 1.0

    //binding
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventAdapter = EventAdapter()
        eventAdapter.setEvent(DataDummy.getListEvent())

        initRecyclerView()

        val mapFragment = SupportMapFragment.newInstance()
        childFragmentManager
            .beginTransaction()
            .add(R.id.map, mapFragment)
            .commit()

        mapFragment.getMapAsync(this)

        eventAdapter.setOnItemClickCallback(object : EventAdapter.OnItemClickCallback {
            override fun onItem(eventName: Event) {
                lat = eventName.lat
                lng = eventName.lng
                mapFragment.getMapAsync(this@MapFragment)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onMapReady(gmap: GoogleMap) {
        val location = LatLng(lat, lng)
        gmap.addMarker(MarkerOptions().position(location).title("MyLocation"))
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 8f))
    }

    private fun initRecyclerView() {
        with(binding.rvEvent) {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = eventAdapter
        }

    }

}