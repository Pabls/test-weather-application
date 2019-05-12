package com.ar4i.testweatherapp.presentation.weather.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.ar4i.testweatherapp.R
import com.ar4i.testweatherapp.data.network.response.WeatherDay
import com.ar4i.testweatherapp.presentation.base.view.BaseFragment
import com.ar4i.testweatherapp.presentation.details.DetailsFragment
import com.ar4i.testweatherapp.presentation.weather.presenter.WeatherPresenter
import io.reactivex.Observable
import kotlinx.android.synthetic.main.item_weather_day.view.*
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
    lateinit var toolbar: Toolbar
    lateinit var vError: View
    lateinit var progressBar: ProgressBar

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

    override fun showError() {
        showError(true)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showData(days: List<WeatherDay>) {
        showError(false)
        adapter.addAllAndNotify(days)
    }

    override fun onItemClick(): Observable<Int> {
        return adapter.itemClickEvent()
    }

    override fun navigateToDetails(weatherDay: WeatherDay, position: Int) {
        var viewHolder = rvDays.findViewHolderForAdapterPosition(position)
        var textview = viewHolder?.itemView?.tv_date!!
        var transitionName = ViewCompat.getTransitionName(textview)
        var fragmentManager = activity?.supportFragmentManager
        fragmentManager?.beginTransaction()
            ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ?.addSharedElement(textview, transitionName!!)
            ?.addToBackStack(null)
            ?.replace(R.id.fl_container, DetailsFragment.newInstance(weatherDay))
            ?.commit()
    }

    private fun initView() {
        vError = activity!!.findViewById(R.id.v_error)
        rvDays = activity!!.findViewById(R.id.rv_days)
        progressBar = activity!!.findViewById(R.id.progressBar)
        adapter = WeatherAdapter()
        rvDays.adapter = adapter
        initToolbar()
    }

    private fun initToolbar() {
        toolbar = activity!!.findViewById(R.id.toolbar)
        toolbar.navigationIcon = null
        toolbar.title = getString(R.string.app_name)
    }


    private fun showError(show: Boolean) {
        rvDays.visibility = if (show) View.GONE else View.VISIBLE
        vError.visibility = if (show) View.VISIBLE else View.GONE
    }
}
