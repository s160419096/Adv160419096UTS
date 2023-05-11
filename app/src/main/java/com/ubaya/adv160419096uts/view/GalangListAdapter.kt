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
import com.ubaya.adv160419096uts.model.GalangDana
import com.ubaya.adv160419096uts.util.loadImage

class GalangListAdapter(val galangList:ArrayList<GalangDana>)
    :RecyclerView.Adapter<GalangListAdapter.GalangViewHolder>()
{
    class GalangViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalangViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.galang_list_item, parent, false)

        return GalangViewHolder(view)
    }

    override fun getItemCount(): Int {
        return galangList.size
    }

    override fun onBindViewHolder(holder: GalangViewHolder, position: Int) {
        val txtTitle = holder.view.findViewById<TextView>(R.id.txtTitle)
        val txtTotalHarga = holder.view.findViewById<TextView>(R.id.txtTotalHarga)
        val txtHariList = holder.view.findViewById<TextView>(R.id.txtHariList)
        val imgList = holder.view.findViewById<ImageView>(R.id.imgList)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        val progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imgList.loadImage(galangList[position].imageUrl, progressBar)

        val galang = galangList[position]
        val galangId = galang.id
        txtTitle.text = galang.title.toString()
        txtTotalHarga.text = "Rp." + galang.totalDonasi.toString()
        txtHariList.text = galang.hari + " hari lagi"
        btnDetail.setOnClickListener {
            val action = MainFragmentDirections.actionMainDetailFragment(galangId!!)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateGalangList(newGalangList: ArrayList<GalangDana>){
        galangList.clear()
        galangList.addAll(newGalangList)
        notifyDataSetChanged()
    }
}