package com.nosetrap.applib.view.widget.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 * this is a custom implementation of the RecyclerViewAdapter class
 * this class allows you to set your own custom data class
 */
abstract class CustomRecyclerViewAdapter<VH : RecyclerView.ViewHolder> (): RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(itemLayoutRes(), parent, false)
        return initViewHolder(view)
    }

    /**
     * this is required,
     * instantiate a ViewHolder object in this abstract method, i.e return ViewHolder(view)
     * @param view is used as a parameter to instantiate the viewholder object
     */
    abstract fun initViewHolder(itemView: View): VH

    /**
     * should return the layout of the items
     */
    abstract fun itemLayoutRes(): Int

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /**
         * easier method of finding a view with findViewById
         */
        fun <T : View> findView(@IdRes viewId: Int): T {
            val view = itemView.findViewById<View>(viewId)
            return view as T
        }
    }
}