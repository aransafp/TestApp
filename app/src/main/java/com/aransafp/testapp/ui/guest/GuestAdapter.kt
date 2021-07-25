package com.aransafp.testapp.ui.guest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aransafp.testapp.data.model.Guest
import com.aransafp.testapp.databinding.ItemsGuestBinding

class GuestAdapter() : RecyclerView.Adapter<GuestAdapter.ViewHolder>() {

    private val listGuest = ArrayList<Guest>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setGuest(listGuest: List<Guest>) {
        this.listGuest.clear()
        this.listGuest.addAll(listGuest)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsGuestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listGuest[position])
    }

    override fun getItemCount(): Int = listGuest.size

    inner class ViewHolder(private val binding: ItemsGuestBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(guest: Guest) {

            with(binding) {

                tvName.text = guest.name
                tvBirthday.text = guest.birthdate

                itemView.setOnClickListener { onItemClickCallback.onItem(guest) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItem(guest: Guest)
    }
}