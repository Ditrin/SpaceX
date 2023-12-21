package com.example.spacexlist.presentation

import com.example.spacexlist.domain.EventItem
import com.example.spacexlist.domain.Interactor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class HistoricalEventsPresenterImpl( //меняет состояние фрагмента
    private val interactor: Interactor,
    private val view: IHistoricalEventsView
) : IHistoricalEventsPresenter {
    private var job: Job? = null
    private val scope = CoroutineScope(MainScope().coroutineContext)

    override fun getHistoricalEvents() {
        job?.cancel()
        job = scope.launch {
            val list: List<EventItem> = interactor.getEventItemList()
            view.showHistoricalEvents(list)
        }
    }

    override fun onDestroy() {
        job?.cancel()
    }
}
