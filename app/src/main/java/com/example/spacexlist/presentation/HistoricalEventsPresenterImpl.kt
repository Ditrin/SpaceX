package com.example.spacexlist.presentation

import com.example.spacexlist.domain.EventItem
import com.example.spacexlist.domain.Interactor

class HistoricalEventsPresenterImpl(
    private val interactor: Interactor,
    private val view: IHistoricalEventsView
) : IHistoricalEventsPresenter{

//    override  fun getHistoricalEvents() {
    //в скоуп
//        val list: List<EventItem> = interactor.getEventItemList()
//        view.showHistoricalEvents(list)
//    }


    override suspend fun getHistoricalEvents() {
        val list: List<EventItem> = interactor.getEventItemList()
        view.showHistoricalEvents(list)
    }
}