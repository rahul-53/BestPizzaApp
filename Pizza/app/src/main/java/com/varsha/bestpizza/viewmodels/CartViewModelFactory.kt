package com.varsha.bestpizza.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.varsha.bestpizza.repository.CartRepository

class CartViewModelFactory(private val repository: CartRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CartViewModel(repository) as T
    }
}