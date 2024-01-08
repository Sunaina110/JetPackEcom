package com.project.jetpackecom.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/*
This view model is used for splash screen and add the delay in splash screen.
 */
class SplashViewModel : ViewModel() {
    private val _loading = MutableStateFlow(true)  // like MutableLiveData<>()
    val loading: StateFlow<Boolean> = _loading  // like LiveData<>()

    private fun splashLoading() {
        viewModelScope.launch {
            delay(2000)
            _loading.value = false
        }
    }

    init {
        splashLoading()
    }

}