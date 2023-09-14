package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiKayitViewModel


class KisiDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

     // tasarim = FragmentKisiDetayBinding.inflate(inflater,container,false)
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false)


        tasarim.kisiDetayFragment=this


        //tasarim.toolbarKisiDetay.title="Kişi Detay"
        tasarim.kisiDetayToolbarBaslik="Kişi Detay"


        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi


        //tasarim.editTextKisiAd.setText(gelenKisi.kisiAd)
        //tasarim.editTextKisiTel.setText(gelenKisi.kisiTel)
        tasarim.kisiNesnesi=gelenKisi

/*
        tasarim.buttonGuncelle.setOnClickListener {
            val kisiAd =tasarim.editTextKisiAd.text.toString()
            val kisiTel = tasarim.editTextKisiTel.text.toString()
         guncelle(gelenKisi.kisiId,kisiAd,kisiTel)
        }
 */
        return tasarim.root
    }

    // view model için:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModeL: KisiDetayViewModel by viewModels()
        viewModel = tempViewModeL
    }

fun buttonGuncelle(kisiId:Int, kisiAd:String,kisiTel:String)
{
   // Log.e("Kişi Güncelle","$kisiId-$kisiAd-$kisiTel")
    viewModel.guncelle(kisiId,kisiAd,kisiTel)

}
}