package ru.happybracket.moretest.modelviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import kotlinx.android.synthetic.main.item_move.view.*
import ru.happybracket.moretest.R
import ru.happybracket.moretest.models.Move

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class MoveView : CardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        inflate(context, R.layout.item_move, this)
        layoutParams = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    @ModelProp
    fun bind(model: Move) {
        item_move_route.visibility = View.VISIBLE
        when {
            model.fromPlace != null && model.toPLace != null ->
                item_move_route.text = resources.getString(
                    R.string.move_route_template,
                    model.fromPlace,
                    model.toPLace
                )
            model.fromPlace != null ->
                item_move_route.text =
                    resources.getString(R.string.move_route_start_template, model.fromPlace)
            model.toPLace != null ->
                item_move_route.text =
                    resources.getString(R.string.move_route_end_template, model.toPLace)
            else ->
                item_move_route.visibility = View.GONE
        }

        when (model.estimateTime) {
            null -> item_move_estimation.visibility = View.GONE
            else -> {
                item_move_estimation.visibility = View.VISIBLE
                item_move_estimation.text =
                    resources.getString(R.string.move_estimate_template, model.estimateTime.toString())
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