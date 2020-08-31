package ru.happybracket.moretest.move

import kotlinx.android.synthetic.main.fragment_move.*
import ru.happybracket.moretest.DetailsFragment
import ru.happybracket.moretest.R

class MoveFragment : DetailsFragment<Move>() {

    override fun layoutId(): Int = R.layout.fragment_move

    override fun bindModel(model: Move) {
        fragment_move_main_view.bind(model)
    }

    companion object : DetailsFragment.DetailsFragmentCompanion<Move, MoveFragment>() {

        override fun cons(): MoveFragment {
            return MoveFragment()
        }

    }

}