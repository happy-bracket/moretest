package ru.happybracket.moretest

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import ru.happybracket.moretest.utils.bundle

abstract class DetailsFragment<M : Parcelable> : Fragment() {

    @LayoutRes
    abstract fun layoutId(): Int

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = arguments?.getParcelable<M>(ARG_MODEL) ?: throw IllegalStateException("${this::class.java.canonicalName} was instantiated using default constructor")
        bindModel(model)
    }

    abstract fun bindModel(model: M)

    abstract class DetailsFragmentCompanion<M : Parcelable, F : DetailsFragment<M>> {

        protected abstract fun cons(): F

        fun Create(model: M): F {
            val fragment = cons()
            fragment.arguments = bundle {
                putParcelable(ARG_MODEL, model)
            }
            return fragment
        }

    }

    companion object {

        private const val ARG_MODEL = "arg_model"

    }

}