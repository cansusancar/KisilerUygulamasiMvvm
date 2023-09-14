package com.example.kisileruygulamasimvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.data.repo.KisilerDaRepository

class AnasayfaViewModel: ViewModel() {
    val krepo= KisilerDaRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
        kisilerListesi= krepo.kisileriGetir()
    }
    fun ara(aramaKelimesi:String)
    {
        krepo.kisiAra(aramaKelimesi)
    }
    fun sil(kisiId:Int) {
        krepo.kisiSil(kisiId)
    }

    fun kisileriYukle() {
        krepo.tumKisileriAl()
    }
}