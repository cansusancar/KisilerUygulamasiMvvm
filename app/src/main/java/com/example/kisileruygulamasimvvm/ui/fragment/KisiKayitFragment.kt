package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiKayitBinding


class KisiKayitFragment : Fragment() {

    private lateinit var tasarim: FragmentKisiKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentKisiKayitBinding.inflate(inflater,container,false)

       tasarim.toolbarKisiKayit.title ="Kişi Kayıt"

        tasarim.buttonKaydet.setOnClickListener {

            val kisiAd = tasarim.editTextKisiAd.text.toString()
            val kisiTel= tasarim.editTextKisiTel.text.toString()
            kayit(kisiAd,kisiTel)

        }





        return tasarim.root
    }
    fun kayit(kisiAd:String,kisiTel:String) {
        Log.e("Kisi Kayit","$kisiAd-$kisiTel")


    }


}