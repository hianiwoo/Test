package com.test.presentation.di

import androidx.lifecycle.ViewModel
import com.test.presentation.main.MainActivity
import com.test.presentation.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBindingsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity
}