package com.ubaya.adv160419096uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.adv160419096uts.model.History

class HistoryDetailViewModel: ViewModel() {
    val historyLD = MutableLiveData<History>()

    fun fetch(){
        val history1 =
            History("1","Galang Dana 1","Rp. 90.100.000",
                "10 hari lagi","Rp. 100.000.000",
                "http://dummyimage.com/75x100.jpg/cc0000/ffffff",
                "123321")
        historyLD.value = history1
    }
}