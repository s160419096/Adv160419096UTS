package com.ubaya.adv160419096uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.adv160419096uts.model.GalangDana
import com.ubaya.adv160419096uts.model.History

class HistoryListViewModel(application: Application):
    AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue:RequestQueue? = null

    val historysLD = MutableLiveData<ArrayList<History>>()
    val historyLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh(){
//        loadingLD.value = true
//        historyLoadErrorLD.value = false
//
//        val id = "1"
//        queue =  Volley.newRequestQueue(getApplication())
//        val url = "http://10.0.2.2/anmp/donasi.php?iduser="+id
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
//                val sType = object : TypeToken<ArrayList<History>>() {}.type
//                val result = Gson().fromJson<ArrayList<History>>(it, sType)
//                historysLD.value = result
//                loadingLD.value = false
//                Log.d("ShowVolley", it)
//            },
//            {
//                Log.d("ShowVolley", it.toString())
//                historyLoadErrorLD.value = true
//                loadingLD.value = false
//            })
//        stringRequest.tag = TAG
//        queue?.add(stringRequest)

        val history1 =
            History("1","Galang Dana 1","Rp. 90.100.000",
                "10 hari lagi", "Rp. 100.000.000",
                "http://dummyimage.com/75x100.jpg/cc0000/ffffff",
                "12121212")
        val history2 =
            History("2","Galang Dana 2","Rp. 89.000.000",
                "15 hari lagi","Rp. 1.000.000.000",
                "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff",
                "54321")
        val history3 =
            History("3","Galang Dana 3","Rp. 2.450.000",
                "20 hari lagi","Rp. 10.000.000",
                "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1",
            "12345")
        val galangList:ArrayList<History> = arrayListOf<History>(history1, history2, history3)
        historysLD.value = galangList
        historyLoadErrorLD.value = false
        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}