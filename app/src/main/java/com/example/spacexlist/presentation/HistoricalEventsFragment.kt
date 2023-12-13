package com.example.spacexlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.spacexlist.R
import com.example.spacexlist.data.repository.SpaceXDataRepository
import com.example.spacexlist.databinding.FragmentHistoricalEventsBinding
import com.example.spacexlist.domain.EventItem
import com.example.spacexlist.domain.EventMapper
import com.example.spacexlist.domain.Interactor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HistoricalEventsFragment : Fragment(R.layout.fragment_historical_events),
    IHistoricalEventsView,
    CoroutineScope {
    private lateinit var historicalEventsAdapter: HistoricalEventsAdapter
    private lateinit var binding: FragmentHistoricalEventsBinding
    private lateinit var interactor: Interactor
    private lateinit var spaceXDataRepository: SpaceXDataRepository
    private lateinit var eventMapper: EventMapper
    private var job: Job = Job()

    private var listEventItem = listOf<EventItem>()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

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
        eventMapper = EventMapper()
        spaceXDataRepository = SpaceXDataRepository()

        interactor = Interactor(eventMapper, spaceXDataRepository)
        val presenter: IHistoricalEventsPresenter =
            HistoricalEventsPresenterImpl(interactor, this)


        viewLifecycleOwner.lifecycleScope.launch {
            listEventItem = interactor.getEventItemList()
        }
        showHistoricalEvents(listEventItem)

        viewLifecycleOwner.lifecycleScope.launch {
            //  historicalEventsPresenter = HistoricalEventsPresenter(interactor, historicalEventsView!!)
            //  historicalEventsPresenter.getHistoricalEvents()
            presenter.getHistoricalEvents()
        }


      ///  presenter.getHistoricalEvents()
    }

    override fun showHistoricalEvents(list: List<EventItem>) {
        historicalEventsAdapter = HistoricalEventsAdapter()

        binding.recyclerView.apply {
            adapter = historicalEventsAdapter
            historicalEventsAdapter.updateEvents(list)

        }
        historicalEventsAdapter.setEventsList(list)
    }
}