package ru.happybracket.moretest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyItemSpacingDecorator
import kotlinx.android.synthetic.main.fragment_main.*
import ru.happybracket.moretest.NavigationConfigHolder
import ru.happybracket.moretest.R
import ru.happybracket.moretest.event.Event
import ru.happybracket.moretest.move.Move
import ru.happybracket.moretest.notice.Notice
import java.util.*

class MainFragment : Fragment() {

    private lateinit var controller: MainController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controller = MainController {
            fragmentManager!!.beginTransaction()
                .add(R.id.main_container, NavigationConfigHolder.dispatcher.requireFragment(it))
                .commit()
        }

        fragment_main_list.layoutManager = LinearLayoutManager(requireContext())
        fragment_main_list.adapter = controller.adapter
        fragment_main_list.addItemDecoration(EpoxyItemSpacingDecorator(resources.getDimensionPixelOffset(R.dimen.main_item_spacing)))

        controller.setItems(listOf(
            Notice(Date(), "G8"),
            Event(Date(), Date(), "MdaHeh"),
            Move("Heh", "Mda", 3.6)
        ))
    }



}