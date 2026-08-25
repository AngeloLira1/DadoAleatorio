package com.example.dadoaleatorio
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DadoViewModel : ViewModel() {

    private val _numeroDado = MutableLiveData<Int>()
    val numeroDado: LiveData<Int> get() = _numeroDado

    fun lanzar() {
        _numeroDado.value = (1..6).random()
    }
}


