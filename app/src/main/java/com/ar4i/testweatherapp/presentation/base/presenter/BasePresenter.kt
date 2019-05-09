package com.ar4i.testweatherapp.presentation.base.presenter

import com.ar4i.testweatherapp.presentation.base.view.IBaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<V : IBaseView> : IBasePresenter<V> {

    private var view: V? = null
    private var compositeDisposable: CompositeDisposable? = null

    override fun attachView(v: V) {
        view = v
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {
        view = null
        compositeDisposable?.dispose()
    }

    override fun getView(): V? {
        return view
    }

    fun track(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }
}