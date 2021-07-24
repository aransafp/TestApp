package com.aransafp.testapp.guest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.aransafp.testapp.data.model.Guest
import com.aransafp.testapp.data.network.ApiConfig
import com.aransafp.testapp.databinding.ActivityGuestBinding
import com.aransafp.testapp.helper.Helper
import com.aransafp.testapp.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuestBinding
    private lateinit var adapter: GuestAdapter

    companion object {
        private val TAG = GuestActivity::class.simpleName

        const val RESULT_CODE = 120
        const val RESULT_GUEST = "result_guest"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = GuestAdapter()
        loadGuest()

        adapter.setOnItemClickCallback(object : GuestAdapter.OnItemClickCallback {
            override fun onItem(guest: Guest) {

                //pass guest name to HomeActivity
                val intent = Intent(this@GuestActivity, HomeActivity::class.java)
                intent.putExtra(RESULT_GUEST, guest.name)
                setResult(RESULT_CODE, intent)

                //show feature based on day birth
                val feature = Helper.getFeature(guest.birthdate)
                showToast(feature)

                finish()
            }
        })

        supportActionBar?.title = "List Guest"

    }

    //Load data from API
    private fun loadGuest() {

        isLoading(true)
        val client = ApiConfig.getApiService().getListGuests()

        client.enqueue(object : Callback<List<Guest>> {
            override fun onResponse(call: Call<List<Guest>>, response: Response<List<Guest>>) {
                if (response.isSuccessful) {
                    Log.d(TAG, "onResponse: ")
                    isLoading(false)
                    val listGuest = response.body()
                    if (listGuest != null) {
                        showRecyclerView(listGuest)
                    }
                } else {
                    isLoading(false)
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Guest>>, t: Throwable) {
                isLoading(false)
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })

    }

    private fun showRecyclerView(listGuest: List<Guest>) {
        binding.rvGuest.layoutManager = GridLayoutManager(this, 2)
        adapter.setGuest(listGuest)
        binding.rvGuest.adapter = adapter
    }

    private fun isLoading(status: Boolean) {
        binding.progressBar.visibility = if (status) View.VISIBLE else View.GONE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}