package com.ubaya.adv160419096uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160419096uts.R
import com.ubaya.adv160419096uts.model.History

class HistoryListAdapter(val historyList: ArrayList<History>) :
RecyclerView.Adapter<HistoryListAdapter.HistoryViewHolder>()
{
    class HistoryViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.history_list_item, parent, false)

        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val txtTitleHistory = holder.view.findViewById<TextView>(R.id.txtTitleHistory)
        val txtTotalHargaHistory = holder.view.findViewById<TextView>(R.id.txtTotalHargaHistory)
        val txtHariListHistory = holder.view.findViewById<TextView>(R.id.txtHariListHistory)
        val txtDonasi = holder.view.findViewById<TextView>(R.id.txtDonasi)
        val imgHistoryList = holder.view.findViewById<ImageView>(R.id.imgListHistory)
        val btnDetailHistory = holder.view.findViewById<Button>(R.id.btnDetailHistory)
        val progressListHistory = holder.view.findViewById<ProgressBar>(R.id.progressBarListHistory)

        val history = historyList[position]
        val historyId = history.id
        txtTitleHistory.text = history.title.toString()
        txtTotalHargaHistory.text = "Rp. " + history.totalDonasi.toString()
        txtHariListHistory.text = history.hari + " hari lagi"
        txtDonasi.text = "Rp. " + history.donasi_user

        btnDetailHistory.setOnClickListener{
            val action = HistoryFragmentDirections.actionHistoryDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateHistoryList(newHistoryList: ArrayList<History>){
        historyList.clear()
        historyList.addAll(newHistoryList)
        notifyDataSetChanged()
    }
}