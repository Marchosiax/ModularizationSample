package com.xvermilion.modulesample.home

import android.os.Bundle
import com.xvermilion.modulesample.shared.EntryActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.android.inject

class HomeActivity : EntryActivity() {

    private val viewModel: HomeViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun init() {

        button.setOnClickListener {
            viewModel.fetchRates()
        }
    }

    override fun loadModules() {
        HomeModules.load()
    }
}