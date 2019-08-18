package com.xvermilion.modulesample.network

import com.xvermilion.modulesample.domain.ports.network.AuthorNetworkPort
import com.xvermilion.modulesample.domain.ports.network.BookNetworkPort
import com.xvermilion.modulesample.domain.ports.network.UserNetworkPort
import com.xvermilion.modulesample.network.adapter.AuthorNetworkAdapter
import com.xvermilion.modulesample.network.adapter.BookNetworkAdapter
import com.xvermilion.modulesample.network.adapter.UserNetworkAdapter
import com.xvermilion.modulesample.network.model.BaseResponse
import com.xvermilion.modulesample.network.webservice.AuthorWebService
import com.xvermilion.modulesample.network.webservice.BookWebService
import com.xvermilion.modulesample.network.webservice.UserWebService
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Proxy
import java.util.concurrent.TimeUnit

object NetworkModules {

    private const val READ_TIMEOUT = 5L
    private const val CONNECTION_TIMEOUT = 5L
    private val TIME_UNIT = TimeUnit.MINUTES

    private val retrofitModule = module {
        single {
            buildRetrofitClient(
                buildOkHttpClient(),
                "https://fakerestapi.azurewebsites.net/api/"
            )
        }
    }

    private val webServiceModule = module {
        single { get<Retrofit>().create(AuthorWebService::class.java) }
        single { get<Retrofit>().create(BookWebService::class.java) }
        single { get<Retrofit>().create(UserWebService::class.java) }
    }

    private val portModule = module {
        single<AuthorNetworkPort> { AuthorNetworkAdapter(get(), get()) }
        single<BookNetworkPort> { BookNetworkAdapter(get(), get()) }
        single<UserNetworkPort> { UserNetworkAdapter(get(), get()) }
    }

    private val errorConverterModule = module {
        single {
            ErrorConverter(
                get<Retrofit>().responseBodyConverter(
                    BaseResponse::class.java,
                    arrayOfNulls<Annotation>(0)
                )
            )
        }
    }

    private fun buildOkHttpClient(
        proxy: Proxy? = Proxy.NO_PROXY,
        pinner: CertificatePinner? = null,
        interceptor: Interceptor? = null
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
            .proxy(proxy)
            .readTimeout(READ_TIMEOUT, TIME_UNIT)
            .connectTimeout(CONNECTION_TIMEOUT, TIME_UNIT)

        pinner?.let { client.certificatePinner(it) }
        interceptor?.let { client.addInterceptor(it) }

        if (BuildConfig.DEBUG)
            client.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .proxy(null)

        return client.build()
    }

    private fun buildRetrofitClient(okHttpClient: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    val modules: List<Module> = listOf(
        retrofitModule, webServiceModule, errorConverterModule, portModule
    )

}