package ru.happybracket.moretest.event

import kotlinx.android.synthetic.main.fragment_event.*
import ru.happybracket.moretest.DetailsFragment
import ru.happybracket.moretest.R

class EventFragment : DetailsFragment<Event>() {

    override fun layoutId(): Int = R.layout.fragment_event

    override fun bindModel(model: Event) {
        fragment_event_main_view.bind(model)
    }

    companion object : DetailsFragment.DetailsFragmentCompanion<Event, EventFragment>() {

        override fun cons(): EventFragment {
            return EventFragment()
        }

    }

}