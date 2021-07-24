package com.aransafp.testapp.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aransafp.testapp.data.model.Event
import com.aransafp.testapp.databinding.ItemsEventBinding
import com.bumptech.glide.Glide

class EventAdapter : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private val listEvent = ArrayList<Event>()

    fun setEvent(listEvent: List<Event>) {
        this.listEvent.clear()
        this.listEvent.addAll(listEvent)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listEvent[position])
    }

    override fun getItemCount(): Int = listEvent.size

    inner class ViewHolder(private val binding: ItemsEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {

            with(binding) {

                tvName.text = event.name
                tvTgl.text = event.tanggal

                Glide.with(itemView.context)
                    .load(event.image)
                    .into(imgPoster)

                itemView.setOnClickListener { onItemClickCallback.onItem(event.name) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItem(eventName: String)
    }
}