package com.test.presentation.home.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.domain.interactor.MainInteractor
import com.test.domain.models.Anime
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val mainInteractor: MainInteractor) : ViewModel() {

    val list = MutableLiveData<List<Anime>>()

    fun load() {
        GlobalScope.launch {
            try {
                val result = mainInteractor.getLast(1, 20)
                list.postValue(result)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}