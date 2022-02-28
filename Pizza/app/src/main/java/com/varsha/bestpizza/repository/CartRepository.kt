package com.varsha.bestpizza.repository

import androidx.lifecycle.LiveData
import com.varsha.bestpizza.local.MyDao
import com.varsha.bestpizza.local.MyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartRepository(private val myDao: MyDao) {

  fun addItems(myEntity: MyEntity){
      CoroutineScope(Dispatchers.IO).launch {
          myDao.insertItems(myEntity)
      }

  }
    fun getItems():LiveData<List<MyEntity>>{
       return myDao.getItems()
    }
    fun totalPrice(): LiveData<Double> {
        return myDao.totalPrice()
    }

}