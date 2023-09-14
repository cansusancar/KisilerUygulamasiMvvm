package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiKayitViewModel


class KisiKayitFragment : Fragment() {

    private lateinit var tasarim: FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      //  tasarim = FragmentKisiKayitBinding.inflate(inflater,container,false)
 // yukarıdaki satır yerine aşağıdakini yazıp değiştirdik
        tasarim =DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit,container,false)


    tasarim.kisiKayitFragment =this
       tasarim.kisiKayitToolbarBaslik ="Kişi Kayıt"


        //xml tarafında click özelliğini veridğimiz için aşağıdaki satırları silebiliriz:
        /*
        tasarim.buttonKaydet.setOnClickListener {
            val kisiAd = tasarim.editTextKisiAd.text.toString()
            val kisiTel= tasarim.editTextKisiTel.text.toString()
            Kayit(kisiAd,kisiTel)
        }
         */

        return tasarim.root
    }


    // view model için
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModeL: KisiKayitViewModel by viewModels()
        viewModel = tempViewModeL
    }


    fun buttonKaydet(kisiAd:String,kisiTel:String) {
       // Log.e("Kisi Kayit","$kisiAd-$kisiTel")
        //Log u burdan kaldırmamıza rağmen KisilerDaRepository'deki log sayesinde log atabiliriz
       viewModel.kayit(kisiAd,kisiTel)

    }


}