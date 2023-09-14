package com.example.kisileruygulamasimvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasimvvm.data.entity.Kisiler

class KisilerDaRepository {
    var kisilerListesi:MutableLiveData<List<Kisiler>>

    init{
        kisilerListesi=MutableLiveData()
    }
    fun kisileriGetir():MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }
    fun kisiKayit(kisiAd: String, kisiTel: String) {
        Log.e("Kisi Kayit", "$kisiAd-$kisiTel")
    }

    fun kisiGuncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        Log.e("Kişi Güncelle", "$kisiId-$kisiAd-$kisiTel")
    }

    fun kisiAra(aramaKelimesi: String) {
        Log.e("Kisi Ara", aramaKelimesi)

    }

fun kisiSil(kisiId:Int){
    Log.e("Kişi Sil",kisiId.toString())
}

    fun tumKisileriAl(){
        val liste= ArrayList<Kisiler>()
        val k1= Kisiler(1,"Cansu","1111")
        val k2= Kisiler(2,"Helin","2222")
        val k3= Kisiler(3,"Orcan","3333")
        val k4= Kisiler(4,"Döne","4444")
        val k5= Kisiler(5,"Büşra","5555")
        val k6= Kisiler(6,"Nazlıcan","6666")
        val k7= Kisiler(7,"Türkan","7777")
        val k8= Kisiler(8,"Can","8888")
        val k9= Kisiler(9,"Ahmet","9999")


       liste.add(k1)
       liste.add(k2)
        liste.add(k3)
        liste.add(k4)
        liste.add(k5)
        liste.add(k6)
        liste.add(k7)
        liste.add(k8)
        liste.add(k9)
        kisilerListesi.value=liste

    }

}

