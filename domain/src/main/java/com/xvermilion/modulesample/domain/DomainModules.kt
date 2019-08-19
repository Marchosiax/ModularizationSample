package com.xvermilion.modulesample.domain

import com.xvermilion.modulesample.domain.repository.AuthorRepositoryAdapter
import com.xvermilion.modulesample.domain.repository.BookRepositoryAdapter
import com.xvermilion.modulesample.domain.repository.UserRepositoryAdapter
import com.xvermilion.modulesample.library.repository.AuthorRepository
import com.xvermilion.modulesample.library.repository.BookRepository
import com.xvermilion.modulesample.library.repository.UserRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModules {

    private val repositoryModule = module {
        single<AuthorRepository> { AuthorRepositoryAdapter(get()) }
        single<BookRepository> { BookRepositoryAdapter(get(), get()) }
        single<UserRepository> { UserRepositoryAdapter(get(), get()) }
    }

    val modules: List<Module> = listOf(repositoryModule)

}