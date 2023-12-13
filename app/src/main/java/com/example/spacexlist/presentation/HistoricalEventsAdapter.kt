package com.example.spacexlist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexlist.databinding.ItemHistoricalEventBinding
import com.example.spacexlist.domain.EventItem

class HistoricalEventsAdapter : RecyclerView.Adapter<HistoricalEventsAdapter.ViewHolder>() {
    private var events = listOf<EventItem>()

    internal fun updateEvents(newEvents: List<EventItem>){
        events = newEvents
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoricalEventsAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoricalEventBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoricalEventsAdapter.ViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size

    inner class ViewHolder(private val binding: ItemHistoricalEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(event: EventItem) {
            with(binding) {
                title.text = event.title
                eventDateUtc.text = event.event_date_utc
                flightNumber.text = event.flight_number.toString()
                details.text = event.details
            }
        }
    }

    fun setEventsList(eventList: List<EventItem>){
        events = eventList.toMutableList()
        notifyDataSetChanged()
    }
}