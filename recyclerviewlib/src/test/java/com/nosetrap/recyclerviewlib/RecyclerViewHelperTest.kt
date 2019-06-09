package com.nosetrap.recyclerviewlib

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.verification.VerificationMode

class RecyclerViewHelperTest {

    val mockRecyclerview = mock(RecyclerView::class.java)

    @Test
    fun builder_setAdapter(){
        val mockAdapter = mock(RecyclerView.Adapter::class.java)

        val builder = RecyclerViewHelper.Builder(mockRecyclerview)
        builder.setAdapter(mockAdapter)
        builder.build()

        Mockito.verify(mockRecyclerview, times(1)).adapter = mockAdapter
    }

    @Test
    fun builder_setItemDecoration(){
        val mockItemDecoration = mock(DividerItemDecoration::class.java)

        val builder = RecyclerViewHelper.Builder(mockRecyclerview)

        builder.setItemDecoration(mockItemDecoration)
        builder.build()

        Mockito.verify(mockRecyclerview, times(1)).addItemDecoration(mockItemDecoration)
    }

    @Test
    fun builder_setLayoutManager(){
        val mockLayoutManager = mock(RecyclerView.LayoutManager::class.java)

        val builder = RecyclerViewHelper.Builder(mockRecyclerview)
        builder.setLayoutManager(mockLayoutManager)
        builder.build()

        Mockito.verify(mockRecyclerview, times(1)).layoutManager = mockLayoutManager
    }

}