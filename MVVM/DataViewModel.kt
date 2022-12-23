package com.example.androidstudioclass.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private val repository = Repository()
    private val _datas= MutableLiveData<ArrayList<Data>>()

    init{
        repository.observeObjectList(_datas)
    }

    val people : LiveData<ArrayList<Data>> get() = _datas
    fun addUser(data : Data){
        repository.postObject(data)
    }
}
