package com.example.kisileruygulamasimvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasimvvm.data.repo.KisilerDaRepository

class KisiDetayViewModel: ViewModel() {
    val krepo= KisilerDaRepository()
    fun guncelle(kisiId:Int, kisiAd:String, kisiTel:String)

    {
        krepo.kisiGuncelle(kisiId,kisiAd,kisiTel)
    }
}