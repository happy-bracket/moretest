package ru.happybracket.moretest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyItemSpacingDecorator
import kotlinx.android.synthetic.main.fragment_main.*
import ru.happybracket.moretest.R
import ru.happybracket.moretest.models.Event
import ru.happybracket.moretest.models.Move
import ru.happybracket.moretest.models.Notice
import java.util.*

class MainFragment : Fragment() {

    private val controller: MainController = MainController {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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