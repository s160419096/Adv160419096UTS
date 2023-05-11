package com.ubaya.adv160419096uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.adv160419096uts.R
import com.ubaya.adv160419096uts.util.loadImage
import com.ubaya.adv160419096uts.viewmodel.HistoryDetailViewModel

class HistoryDetailFragment : Fragment() {
    private lateinit var viewModel: HistoryDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HistoryDetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel(view)
    }

    fun observeViewModel(view: View){
        viewModel.historyLD.observe(viewLifecycleOwner, Observer {
            val txtTitleDetail = view.findViewById<TextView>(R.id.txtTitleDetailHistory)
            val txtTotalHargaDetail = view.findViewById<TextView>(R.id.txtTotalHargaDetailHistory)
            val txtTerkumpul = view.findViewById<TextView>(R.id.txtTerkumpulHistory)
            val txtHari = view.findViewById<TextView>(R.id.txtHariHistory)
            val imgDetail = view.findViewById<ImageView>(R.id.imgDetail)
            val progressBarDetail = view.findViewById<ProgressBar>(R.id.progressBarDetailHistory)

            imgDetail.loadImage(it.imageUrl, progressBarDetail)

            txtTitleDetail.text = it.title.toString()
            txtTotalHargaDetail.text = "Rp." + it.totalDonasi.toString()
            txtTerkumpul.text = "Terkumpul dari Rp." + it.donasi.toString()
            txtHari.text = it.hari.toString() + " hari lagi"
        })
    }
}