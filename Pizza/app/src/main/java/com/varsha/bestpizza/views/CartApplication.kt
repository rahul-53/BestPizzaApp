package com.varsha.bestpizza

import android.app.Application
import com.varsha.bestpizza.local.MyDatabase
import com.varsha.bestpizza.repository.CartRepository

class CartApplication : Application() {
    private val myDao by lazy {
        val roomDatabase = MyDatabase.getDatabase(this)
        roomDatabase.getMyDao()
    }
    val repository: CartRepository by lazy {
        CartRepository(myDao)
    }
}