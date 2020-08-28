package ru.happybracket.moretest.modelviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import kotlinx.android.synthetic.main.item_event.view.*
import ru.happybracket.moretest.R
import ru.happybracket.moretest.models.Event
import java.text.DateFormat
import java.util.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class EventView : CardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US)

    init {
        inflate(context, R.layout.item_event, this)
        layoutParams = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    @ModelProp
    fun bind(model: Event) {
        item_event_title.text = model.name
        item_event_date.visibility = View.VISIBLE
        when {
            model.startTime != null && model.endTime != null ->
                item_event_date.text = resources.getString(
                    R.string.event_date_template,
                    dateFormat.format(model.startTime),
                    dateFormat.format(model.endTime)
                )
            model.startTime != null ->
                item_event_date.text = dateFormat.format(model.startTime)
            model.endTime != null ->
                item_event_date.text = dateFormat.format(model.endTime)
            else ->
                item_event_date.visibility = View.GONE
        }
    }

    @CallbackProp
    fun onClick(listener: (() -> Unit)?) {
        setOnClickListener {
            listener?.invoke()
        }
    }

}