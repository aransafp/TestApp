package com.aransafp.testapp.ui.map

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aransafp.testapp.R
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = SupportMapFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.map, mapFragment)
            .commit()

        mapFragment.getMapAsync { gmap ->
            val location = LatLng(13.03, 77.60)
            gmap.addMarker(MarkerOptions().position(location).title("MyLocation"))
            gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))
        }
    }
}