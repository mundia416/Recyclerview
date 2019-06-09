package com.nosetrap.recyclerviewlib

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * a helper class for the recyclerView
 */
class RecyclerViewHelper private constructor(){


    /**
     *
     */
    class Builder(private var recyclerView: RecyclerView){
        private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
        private var itemDecoration: DividerItemDecoration? = null
        private var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(recyclerView.context)

        /**
         * set adapter
         * @param adapter should be of a class that extends recyclerview.Adapter otherwise a
         * class cast exception will be thrown if its not of type
         */
        fun setAdapter(adapter: Any): Builder {
            this.adapter = adapter as RecyclerView.Adapter<RecyclerView.ViewHolder>
            return  this
        }

        fun setItemDecoration(itemDecoration: DividerItemDecoration): Builder {
            this.itemDecoration = itemDecoration
            return this
        }

        fun setLayoutManager(layoutManager: RecyclerView.LayoutManager): Builder {
            this.layoutManager = layoutManager
            return this
        }

        fun build(){
             recyclerView.adapter = adapter
            if(itemDecoration != null) {
              recyclerView.addItemDecoration(itemDecoration!!)
            }
            recyclerView.layoutManager = layoutManager
        }
    }


    /**
     * a recyclerView with a linearlayoutManager
     */
    class LinearBuilder(private var recyclerView:RecyclerView){
        private val builder = Builder(recyclerView)
        private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
        private var showLineSeperator = true
        private var isHorizontal = false
        private var verticalLayoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
        private var horizontalLayoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
        private var verticalDecoration = DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        private var horizontalDecoration = DividerItemDecoration(recyclerView.context, DividerItemDecoration.HORIZONTAL)

        fun setAdapter(adapter: Any): LinearBuilder {
            this.adapter = adapter as RecyclerView.Adapter<RecyclerView.ViewHolder>
            return  this
        }

        /**
         * show the divider item decoration
         * default value is true
         */
        fun showLineSeperator(show: Boolean): LinearBuilder {
            showLineSeperator = show
            return this
        }

        /**
         * set the orientation of the recyclerview
         */
        fun isHorizontal(value: Boolean): LinearBuilder {
            this.isHorizontal = value
            return this
        }

        fun build(){
            builder.setLayoutManager(if(isHorizontal){horizontalLayoutManager}else{verticalLayoutManager})
            if(adapter != null) {
                builder.setAdapter(adapter!!)
            }

            if(showLineSeperator) {
                builder.setItemDecoration(if(isHorizontal){horizontalDecoration}else{verticalDecoration})
            }

            builder.build()
        }
    }


    /**
     * a recyclerView with a gridBuilder
     */
    class GridBuilder(private var recyclerView: RecyclerView){
        private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
        private val builder = Builder(recyclerView)
        private var isHorizontal = false
        private var SpanCount = 2

        private var showHorizontalLineSeperator = false
        private var showVerticalLineSeperator = false
       private var horizontalDecoration = DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        private var verticalDecoration = DividerItemDecoration(recyclerView.context, DividerItemDecoration.HORIZONTAL)

        /**
         * show the divider item decoration
         * default value is true
         */
        fun showHorizontalLineSeperator(show: Boolean): GridBuilder {
            showHorizontalLineSeperator = show
            return this
        }

        /**
         * show the divider item decoration
         * default value is true
         */
        fun showVerticalLineSeperator(show: Boolean): GridBuilder {
            showVerticalLineSeperator = show
            return this
        }

        fun setAdapter(adapter: Any): GridBuilder {
            this.adapter = adapter as RecyclerView.Adapter<RecyclerView.ViewHolder>
            return  this
        }

        /**
         * default value is 2
         */
        fun setSpanCount(count: Int): GridBuilder {
            this.SpanCount = count
            return this
        }

        /**
         * set the orientation of the recyclerview
         */
        fun isHorizontal(value: Boolean): GridBuilder {
            this.isHorizontal = value
            return this
        }

        fun build(){
            var verticalLayoutManager = GridLayoutManager(recyclerView.context, SpanCount, RecyclerView.VERTICAL, false)
            var horizontalLayoutManager = GridLayoutManager(recyclerView.context, SpanCount, LinearLayoutManager.HORIZONTAL, false)

            builder.setLayoutManager(if(isHorizontal){horizontalLayoutManager}else{verticalLayoutManager})
            if(adapter != null) {
                builder.setAdapter(adapter!!)
            }

            //
            if(showHorizontalLineSeperator) {
                recyclerView.addItemDecoration(horizontalDecoration)
            }
            //
            if(showVerticalLineSeperator){
                recyclerView.addItemDecoration(verticalDecoration)
            }


            builder.build()
        }
    }

    /**
     * a recyclerView with a staggered grid layout manager
     */
    class StaggeredGridBuilder(private val activity: AppCompatActivity,private var recyclerView: RecyclerView){
        private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
        private val builder = Builder(recyclerView)
        private var isHorizontal = false
        private var SpanCount = 2
        private var showHorizontalLineSeperator = false
        private var showVerticalLineSeperator = false
        private var horizontalDecoration = DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        private var verticalDecoration = DividerItemDecoration(recyclerView.context, DividerItemDecoration.HORIZONTAL)

        /**
         * show the divider item decoration
         * default value is true
         */
        fun showHorizontalLineSeperator(show: Boolean): StaggeredGridBuilder {
            showHorizontalLineSeperator = show
            return this
        }

        /**
         * show the divider item decoration
         * default value is true
         */
        fun showVerticalLineSeperator(show: Boolean): StaggeredGridBuilder {
            showVerticalLineSeperator = show
            return this
        }
        fun setAdapter(adapter: Any): StaggeredGridBuilder {
            this.adapter = adapter as RecyclerView.Adapter<RecyclerView.ViewHolder>
            return  this        }

        /**
         * default value is 2
         */
        fun setSpanCount(count: Int): StaggeredGridBuilder {
            this.SpanCount = count
            return this
        }

        /**
         * set the orientation of the recyclerview
         */
        fun isHorizontal(value: Boolean): StaggeredGridBuilder {
            this.isHorizontal = value
            return this
        }
//todo setting a gap strategy
        fun build(){
            var verticalLayoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(SpanCount,LinearLayoutManager.VERTICAL)
            var horizontalLayoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(SpanCount, LinearLayoutManager.HORIZONTAL)

            builder.setLayoutManager(if(isHorizontal){horizontalLayoutManager}else{verticalLayoutManager})
            if(adapter != null) {
                builder.setAdapter(adapter!!)
            }


            //
            if(showHorizontalLineSeperator) {
                recyclerView.addItemDecoration(horizontalDecoration)
            }
            //
            if(showVerticalLineSeperator){
                recyclerView.addItemDecoration(verticalDecoration)
            }


            builder.build()
        }
    }
}