package com.ubaya.adv160419096uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ubaya.adv160419096uts.R
import com.ubaya.adv160419096uts.viewmodel.HistoryListViewModel

class HistoryFragment : Fragment() {
    private lateinit var viewModel: HistoryListViewModel
    private val historyListAdapter = HistoryListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HistoryListViewModel::class.java)
        viewModel.refresh()

        val recViewHistory = view.findViewById<RecyclerView>(R.id.recViewHistory)
        recViewHistory.layoutManager = LinearLayoutManager(context)
        recViewHistory.adapter = historyListAdapter

        observeViewModel(view)

        val txtErrorHistory = view.findViewById<TextView>(R.id.txtErrorHistory)
        val progressLoadHistory = view.findViewById<ProgressBar>(R.id.progressLoadHistory)
        val refreshLayoutHistory = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayoutHistory)
        refreshLayoutHistory.setOnRefreshListener {
            recViewHistory.visibility = View.GONE
            txtErrorHistory.visibility = View.GONE
            progressLoadHistory.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayoutHistory.isRefreshing = false
        }

    }

    fun observeViewModel(view: View) {
        viewModel.historysLD.observe(viewLifecycleOwner, Observer {
            historyListAdapter.updateHistoryList(it)
        })

        val txtErrorHistory = view.findViewById<TextView>(R.id.txtErrorHistory)
        val recViewHistory = view.findViewById<RecyclerView>(R.id.recViewHistory)
        val progressLoadHistory = view.findViewById<ProgressBar>(R.id.progressLoadHistory)
        viewModel.historyLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorHistory.visibility = View.VISIBLE
            } else {
                txtErrorHistory.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recViewHistory.visibility = View.GONE
                progressLoadHistory.visibility = View.VISIBLE
            } else {
                recViewHistory.visibility = View.VISIBLE
                progressLoadHistory.visibility = View.GONE
            }
        })
    }
}