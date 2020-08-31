package ru.happybracket.moretest.notice

import kotlinx.android.synthetic.main.fragment_notice.*
import ru.happybracket.moretest.DetailsFragment
import ru.happybracket.moretest.R

class NoticeFragment : DetailsFragment<Notice>() {

    override fun layoutId(): Int = R.layout.fragment_notice

    override fun bindModel(model: Notice) {
        fragment_notice_view.bind(model)
    }

    companion object : DetailsFragment.DetailsFragmentCompanion<Notice, NoticeFragment>() {

        override fun cons(): NoticeFragment {
            return NoticeFragment()
        }

    }

}