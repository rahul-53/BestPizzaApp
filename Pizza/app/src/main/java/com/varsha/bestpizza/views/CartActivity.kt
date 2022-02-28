package com.varsha.bestpizza.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.varsha.bestpizza.CartApplication
import com.varsha.bestpizza.R
import com.varsha.bestpizza.adapter.CartAdapter
import com.varsha.bestpizza.local.MyEntity
import com.varsha.bestpizza.viewmodels.CartViewModel
import com.varsha.bestpizza.viewmodels.CartViewModelFactory
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {
    private lateinit var viewModel: CartViewModel
    private val cartList = mutableListOf<MyEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val adapter2 = CartAdapter(cartList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter2

        val appObj = application as CartApplication
        val repository = appObj.repository
        val viewModelFactory = CartViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CartViewModel::class.java)

        viewModel.getItems().observe(this, Observer {
            cartList.clear()
            cartList.addAll(it)
            adapter2.notifyDataSetChanged()
        })
        viewModel.totalPrice().observe(this, Observer {
            text_totalPrice.text= "Total Price is ₹ $it"
        })
    }
}