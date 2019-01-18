package com.uvr.rapidlist

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.uvr.rapidlist.databinding.ActivityMainBinding
import com.uvr.rapidlist.model.RecyclerViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.recyclerViewModel = RecyclerViewModel(this)
    }
}
