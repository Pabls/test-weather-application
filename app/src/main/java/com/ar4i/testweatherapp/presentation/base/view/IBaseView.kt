package com.ar4i.testweatherapp.presentation.base.view

interface IBaseView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String)
    fun showError()
}