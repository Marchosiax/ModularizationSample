package com.xvermilion.modulesample

import android.content.ContentResolver
import com.xvermilion.modulesample.domain.DomainModules
import com.xvermilion.modulesample.network.NetworkModules
import com.xvermilion.modulesample.persistence.PersistenceModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object ModuleProvider {

    private val appModules = module {
        single<ContentResolver> { androidContext().contentResolver }
    }

    val modules: List<Module>
        get() {
            return ArrayList<Module>().apply {
                add(appModules)
                addAll(DomainModules.modules)
                addAll(PersistenceModules.modules)
                addAll(NetworkModules.modules)
            }
        }

}