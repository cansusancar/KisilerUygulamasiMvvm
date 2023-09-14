package com.example.kisileruygulamasimvvm.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


fun Navigation.gecisYap(id:Int,it: View){
    findNavController(it).navigate(id)

}

// aşağıdaki fonksiyona aynı ismi verdik ama bu bir zorunluluk değil
fun Navigation.gecisYap(it:View,id :NavDirections){
    findNavController(it).navigate(id)
}