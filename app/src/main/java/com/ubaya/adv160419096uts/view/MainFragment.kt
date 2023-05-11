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
//import com.ubaya.adv160419096uts.MainFragmentDirections
import com.ubaya.adv160419096uts.R
import com.ubaya.adv160419096uts.viewmodel.ListViewModel

class MainFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val galangListAdapter = GalangListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recViewHistory)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = galangListAdapter

        val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoad)
        val txtError = view.findViewById<TextView>(R.id.txtError)
        val refreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        refreshLayout.setOnClickListener {
            recView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel(view)
    }

    fun observeViewModel(view: View) {
        viewModel.galangsLD.observe(viewLifecycleOwner, Observer {
            galangListAdapter.updateGalangList(it)
        })

        val txtError = view.findViewById<TextView>(R.id.txtError)
        val recView = view.findViewById<RecyclerView>(R.id.recViewHistory)
        val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoad)
        viewModel.galangLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtError.visibility = View.VISIBLE
            } else {
                txtError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            } else {
                recView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        })
    }
}