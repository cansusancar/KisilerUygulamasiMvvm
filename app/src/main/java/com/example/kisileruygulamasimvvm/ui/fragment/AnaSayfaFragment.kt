package com.example.kisileruygulamasimvvm.ui.fragment
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView// bu kısımda import ederken seçenekler arasında android değil androidx olmasına dikkat etmeliyiz
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasimvvm.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasimvvm.util.gecisYap


class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {

private lateinit var tasarim: FragmentAnaSayfaBinding
private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //tasarim = FragmentAnaSayfaBinding.inflate(inflater,container,false)
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa,container,false)

        tasarim.anasayfaFragment= this


       // tasarim.toolbarAnaSayfa.title ="Kisiler"
        tasarim.anasayfaToolbarBaslik="Kişiler"


        (activity as AppCompatActivity). setSupportActionBar(tasarim.toolbarAnaSayfa)


        tasarim.rv.layoutManager=LinearLayoutManager(requireContext())

        /* ctrl +x ile buradan alıp KisilerDaRepository kısmına attık
        val kisilerListesi = ArrayList<Kisiler>()
        val k1=Kisiler(1,"Cansu","1111")
        val k2=Kisiler(2,"Helin","2222")
        val k3=Kisiler(3,"Orcan","3333")
        val k4=Kisiler(4,"Döne","4444")
        val k5=Kisiler(5,"Büşra","5555")
        val k6=Kisiler(6,"Nazlıcan","6666")
        val k7=Kisiler(7,"Türkan","7777")
        val k8=Kisiler(8,"Can","8888")
        val k9=Kisiler(9,"Ahmet","9999")


        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)
        kisilerListesi.add(k5)
        kisilerListesi.add(k6)
        kisilerListesi.add(k7)
        kisilerListesi.add(k8)
        kisilerListesi.add(k9)

         */

        viewModel.kisilerListesi.observe(viewLifecycleOwner) {
            val adapter= KisilerAdapter(requireContext(),it,viewModel)

            //  tasarim.rv.adapter= adapter
            tasarim.kisilerAdapter=adapter
        }

        /* aşağıdaki kısmı yukarı aktardık
        val adapter= KisilerAdapter(requireContext(), kisilerListesi,viewModel)

      //  tasarim.rv.adapter= adapter
        tasarim.kisilerAdapter=adapter


         */
/*
        tasarim.fab.setOnClickListener{
Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }


 */
        requireActivity().addMenuProvider(object:MenuProvider
        {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater){
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView// SearchView özelliğine sahip bir action tanımladık
            searchView.setOnQueryTextListener(this@AnaSayfaFragment)

            }
            override fun onMenuItemSelected(menuItem: MenuItem):Boolean {
                return false
            }
        },viewLifecycleOwner, Lifecycle.State.RESUMED)
        return tasarim.root
    }


    // view model için
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModeL: AnasayfaViewModel by viewModels()
        viewModel = tempViewModeL
    }
    fun fabTikla(it:View) {
    //extension kısmında burayı değiştirdik
    //Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
    Navigation.gecisYap(R.id.kisiKayitGecis,it)
    }
    override fun onQueryTextSubmit(query: String): Boolean {


        //ara(query) // harfler tuşlayıp enter kısmına bastığımızda bu fonksiyon çalışır?
        viewModel.ara(query)

        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {

        // ara(newText) // harf girerken ilk etapta bu fonksiyon çalışır?
        viewModel.ara(newText)

        return true
    }

    /*
    ANA SAYFA VİEW MODELE YAZINCA BURAYA GEREK KALMADI?
    fun ara(aramaKelimesi:String) {
        Log.e("Kisi Ara",aramaKelimesi)
    }

     */

    override fun onResume() {
        super.onResume()
       // Log.e("Kisi Anasayfa", "Dönüldü")
    viewModel.kisileriYukle()
    }


}