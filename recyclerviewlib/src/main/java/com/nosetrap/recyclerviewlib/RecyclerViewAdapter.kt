package com.nosetrap.applib.view.widget.recyclerview

import android.app.Activity
import android.content.Context
import androidx.recyclerview.widget.RecyclerView

/**
 * <Data> is the class type for the type of data the recyclerView will be displaying
 *
 */
 abstract class RecyclerViewAdapter<Data,VH : RecyclerView.ViewHolder>() :
        CustomRecyclerViewAdapter<VH>() {


    /**
     * the data which the recyclerView will be displaying
     * when it is set notifyDataSetChanged() is called
     */
    var data = ArrayList<Data>()
    set(value){
        field = value
       notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    /**
     *
     */
    fun removeItem(index: Int){
        val success = data.remove(data[index])
        if(success) {
            notifyItemRemoved(index)
        }
    }

    /**
     *
     */
    fun addItem(item: Data){
        data.add(item)
        notifyItemInserted(data.lastIndex)
    }


    /**
     * get rid of all the items in the recyclerView
     */
    fun clear(){
        data.clear()
        notifyDataSetChanged()
    }
}