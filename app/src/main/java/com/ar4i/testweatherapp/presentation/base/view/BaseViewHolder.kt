package com.ar4i.testweatherapp.presentation.base.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.subjects.PublishSubject

abstract class BaseViewHolder<V> : RecyclerView.ViewHolder {

    constructor(item: View, itemViewClickSubject: PublishSubject<Int>) : super(item) {
        RxView.clicks(item)
            .map { adapterPosition }
            .filter { position -> position >= 0 }
            .subscribe(itemViewClickSubject)
    }

    abstract fun bind(item: V)
}