package com.varsha.bestpizza.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varsha.bestpizza.models.PizzaResponse
import com.varsha.bestpizza.repository.PizzaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel(val repository: PizzaRepository):ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getPizza()
        }
    }
    val pizzas: LiveData<PizzaResponse>
    get() = repository.pizzas


}