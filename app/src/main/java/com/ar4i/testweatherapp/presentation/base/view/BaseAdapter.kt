package com.ar4i.testweatherapp.presentation.base.view

import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

abstract class BaseAdapter<V, VH : BaseViewHolder<V>> : RecyclerView.Adapter<VH>() {

    protected var items: List<V> = mutableListOf<V>()

    private var itemViewClickSubject: PublishSubject<Int> = PublishSubject.create()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun getItem(position: Int): V {
        return items.get(position)
    }

    protected fun getSubject(): PublishSubject<Int> {
        return itemViewClickSubject
    }

    fun addAllAndNotify(items: List<V>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun itemClickEvent(): Observable<Int> {
        return itemViewClickSubject
    }
}