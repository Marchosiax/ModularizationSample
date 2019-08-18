package com.xvermilion.modulesample.persistence

import android.app.Application
import androidx.room.Room
import com.xvermilion.modulesample.domain.ports.persistence.PreferenceStorage
import com.xvermilion.modulesample.domain.ports.persistence.UserDaoPort
import com.xvermilion.modulesample.persistence.DatabaseMetaData.NAME
import com.xvermilion.modulesample.persistence.adapters.UserDaoAdapter
import com.xvermilion.modulesample.persistence.preferences.SharedPreferenceStorage
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object PersistenceModules {

    private val databaseModule = module {
        single {
            val app: Application = get()
            Room.databaseBuilder(app, MyDatabase::class.java, NAME).build()
        }
    }

    private val daoModules = module {
        single { get<MyDatabase>().userDao() }
    }

    private val portsModule = module {
        single<UserDaoPort> { UserDaoAdapter(get()) }
        single<PreferenceStorage> { SharedPreferenceStorage(androidContext()) }
    }

    val modules: List<Module> = listOf(databaseModule, daoModules, portsModule)

}