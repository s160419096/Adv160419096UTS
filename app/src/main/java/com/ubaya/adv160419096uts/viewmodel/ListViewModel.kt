package com.ubaya.adv160419096uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.adv160419096uts.model.GalangDana

class ListViewModel(application: Application):
    AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    val galangsLD = MutableLiveData<ArrayList<GalangDana>>()
    val galangLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()


    fun refresh() {
        loadingLD.value = true
        galangLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/anmp/satu_jiwa.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<GalangDana>>() {}.type
                val result = Gson().fromJson<ArrayList<GalangDana>>(it, sType)
                galangsLD.value = result
                loadingLD.value = false
                Log.d("ShowVolley", it)
            },
            {
                Log.d("ShowVolley", it.toString())
                galangLoadErrorLD.value = true
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

//        val galang1 =
//            GalangDana("1","Galang Dana 1","Rp. 90.100.000","10 hari lagi","Rp. 100.000.000", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//        val galang2 =
//            GalangDana("2","Galang Dana 2","Rp. 89.000.000","15 hari lagi","Rp. 1.000.000.000", "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff")
//        val galang3 =
//            GalangDana("3","Galang Dana 3","Rp. 2.450.000","20 hari lagi","Rp. 10.000.000", "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
//        val galangList:ArrayList<GalangDana> = arrayListOf<GalangDana>(galang1, galang2, galang3)
//        galangsLD.value = galangList
//        galangLoadErrorLD.value = false
//        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}