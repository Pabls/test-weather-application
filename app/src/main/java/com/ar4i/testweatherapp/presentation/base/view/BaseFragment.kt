package com.ar4i.testweatherapp.presentation.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ar4i.testweatherapp.app.App
import com.ar4i.testweatherapp.app.di.components.ApplicationComponent

abstract class BaseFragment : Fragment(), IBaseView {

    companion object {
        @JvmStatic
        fun newInstance() = BaseFragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun inject()

    fun getComponent(): ApplicationComponent {
        return App.appComponent
    }
}