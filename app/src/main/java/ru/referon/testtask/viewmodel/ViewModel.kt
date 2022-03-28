package ru.referon.testtask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.referon.testtask.FeedModel
import ru.referon.testtask.repository.RepositoryImpl
import java.lang.Exception

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = RepositoryImpl()
    private val _data = MutableLiveData(FeedModel())
    val data: LiveData<FeedModel>
        get() = _data

    fun loadFoods() {

        _data.value = FeedModel(loading = true)
        viewModelScope.launch {
            try {
                val foods = repository.getFoods()
                _data.value = FeedModel(foods=foods)
            } catch (e: Exception) {
                _data.value = FeedModel(error = true)
            }

        }
    }
}