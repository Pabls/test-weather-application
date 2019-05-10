package com.ar4i.testweatherapp.presentation.weather.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ar4i.testweatherapp.R
import com.ar4i.testweatherapp.data.network.response.WeatherDay
import com.ar4i.testweatherapp.presentation.base.view.BaseFragment
import com.ar4i.testweatherapp.presentation.weather.presenter.WeatherPresenter
import io.reactivex.Observable
import javax.inject.Inject

class WeatherFragment : BaseFragment(), IWeatherView {

    companion object {
        @JvmStatic
        fun newInstance(): WeatherFragment {
            return WeatherFragment()
        }
    }

    @Inject
    lateinit var presenter: WeatherPresenter
    lateinit var adapter: WeatherAdapter
    lateinit var rvDays: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        presenter.attachView(this)
    }

    override fun onDetach() {
        super.onDetach()
        presenter.detachView()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_weather
    }

    override fun inject() {
        getComponent().inject(this)
    }

    override fun showData(days: List<WeatherDay>) {
        adapter.addAllAndNotify(days)
    }

    override fun onItemClick(): Observable<Int> {
        return adapter.itemClickEvent()
    }

    private fun initView() {
        rvDays = activity!!.findViewById(R.id.rv_days)
        adapter = WeatherAdapter()
        rvDays.adapter = adapter
    }
}
