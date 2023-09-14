package com.example.kisileruygulamasimvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasimvvm.data.repo.KisilerDaRepository

class KisiKayitViewModel:ViewModel() {
    val krepo= KisilerDaRepository()
    fun kayit(kisiAd:String,kisiTel:String) {
       // Log.e("Kişi Kayıt","${kisiAd-$kisiTel}")
    krepo.kisiKayit(kisiAd,kisiTel)
    }
}