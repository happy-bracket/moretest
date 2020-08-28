package ru.happybracket.moretest.modelviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import kotlinx.android.synthetic.main.item_notice.view.*
import ru.happybracket.moretest.R
import ru.happybracket.moretest.models.Notice
import java.text.DateFormat
import java.util.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class NoticeView : CardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val dateFormat =
        DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, Locale.US)

    init {
        inflate(context, R.layout.item_notice, this)
        layoutParams = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    @ModelProp
    fun bind(model: Notice) {
        item_notice_title.text = resources.getString(R.string.flight_title_template, model.gate)
        when (model.flightDate) {
            null -> item_notice_date.visibility = View.GONE
            else -> {
                item_notice_date.visibility = View.VISIBLE
                item_notice_date.text = dateFormat.format(model.flightDate)
            }
        }
    }

    @CallbackProp
    fun onClick(listener: (() -> Unit)?) {
        setOnClickListener {
            listener?.invoke()
        }
    }

}