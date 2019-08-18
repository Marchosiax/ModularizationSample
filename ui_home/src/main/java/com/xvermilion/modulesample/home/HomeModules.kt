package com.xvermilion.modulesample.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object HomeModules {

    fun load() = load

    private val load by lazy {
        loadKoinModules(viewModelModules)
    }

    private val viewModelModules = module {
        viewModel { HomeViewModel(get()) }
    }

}