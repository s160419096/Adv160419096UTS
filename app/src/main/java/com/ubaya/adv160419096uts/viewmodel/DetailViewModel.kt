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

class DetailViewModel(application: Application):
    AndroidViewModel(application) {
    val galangLD = MutableLiveData<GalangDana>()
    val TAG = "volleyDetailTag"
    private var queue: RequestQueue? = null

    fun fetch(galangId: String){
        queue = Volley.newRequestQueue(getApplication())
        var url = "http://10.0.2.2/anmp/satujiwa.php?id="+galangId

        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val sType = object : TypeToken<GalangDana>(){}.type
                val result = Gson().fromJson<GalangDana>(it, sType)

                galangLD.value = result
                Log.d("detailVolley", result.toString())
            },{
                Log.d("detailVolley", it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)

//        val galang1 =
//            GalangDana("1","Galang Dana 1","Rp. 90.100.000","10 hari lagi","Rp. 100.000.000", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//        galangLD.value = galang1
    }
}