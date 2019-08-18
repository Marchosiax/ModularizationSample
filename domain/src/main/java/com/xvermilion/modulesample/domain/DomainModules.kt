package com.xvermilion.modulesample.domain

import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModules {

    private val repositoryModule = module {
        //single<BankAccountRepository> { BankAccountRepositoryAdapter(get(), get()) }
    }

    val modules: List<Module> = listOf(repositoryModule)

}