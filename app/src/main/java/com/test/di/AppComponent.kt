package com.test.di

import android.app.Application
import com.test.App
import com.test.di.modules.NetworkModule
import com.test.presentation.di.ActivityBindingsModule
import com.test.presentation.di.FragmentBindingsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ActivityBindingsModule::class,
        FragmentBindingsModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}