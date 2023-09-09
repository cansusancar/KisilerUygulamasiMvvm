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
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentAnaSayfaBinding


class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {

private lateinit var tasarim: FragmentAnaSayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentAnaSayfaBinding.inflate(inflater,container,false)


        tasarim.toolbarAnaSayfa.title ="Kisiler"
        (activity as AppCompatActivity). setSupportActionBar(tasarim.toolbarAnaSayfa)
        tasarim.fab.setOnClickListener{
Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

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

    override fun onQueryTextSubmit(query: String): Boolean {
     ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
       ara(newText)
        return true
    }

    fun ara(aramaKelimesi:String) {
        Log.e("Kisi Ara",aramaKelimesi)
    }


}