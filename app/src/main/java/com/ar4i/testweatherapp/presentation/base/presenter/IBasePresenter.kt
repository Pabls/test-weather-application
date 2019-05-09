package com.ar4i.testweatherapp.presentation.base.presenter

interface IBasePresenter<V> {
    fun attachView(v: V)
    fun detachView()
    fun getView(): V?
}