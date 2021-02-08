package com.test

import android.app.Application
import com.test.data.api.ApiService
import com.test.di.AppComponent
import com.test.di.DaggerAppComponent
import com.test.domain.interactor.MainInteractor
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    companion object {

        lateinit var apiService: ApiService
        lateinit var mainInteractor: MainInteractor

    }

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().app(this).build()
        appComponent.inject(this)
        apiService = createRetrofit().create(
            ApiService::class.java
        )
        mainInteractor = MainInteractor(apiService)
    }

    private fun createRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(20L, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.animevost.org/animevost/api/v0.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    override fun androidInjector(): AndroidInjector<Any> = injector
}