package com.example.spacexlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spacexlist.R
import com.example.spacexlist.data.repository.SpaceXDataRepository
import com.example.spacexlist.databinding.FragmentHistoricalEventsBinding
import com.example.spacexlist.domain.EventItem
import com.example.spacexlist.domain.EventMapper
import com.example.spacexlist.domain.Interactor

class HistoricalEventsFragment : Fragment(R.layout.fragment_historical_events),
    IHistoricalEventsView {
    private lateinit var historicalEventsAdapter: HistoricalEventsAdapter
    private lateinit var binding: FragmentHistoricalEventsBinding
    private var spaceXDataRepository: SpaceXDataRepository = SpaceXDataRepository()
    private var eventMapper: EventMapper = EventMapper()
    private var interactor: Interactor = Interactor(eventMapper, spaceXDataRepository)
    private val presenter: IHistoricalEventsPresenter =
        HistoricalEventsPresenterImpl(interactor, this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoricalEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historicalEventsAdapter = HistoricalEventsAdapter()
        binding.recyclerView.adapter = historicalEventsAdapter

        presenter.getHistoricalEvents()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showHistoricalEvents(list: List<EventItem>) {

        historicalEventsAdapter.apply {
            historicalEventsAdapter.setEventsList(list)
        }
    }
}