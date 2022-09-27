package net.simplifiedcoding.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.simplifiedcoding.data.network.Resource
import net.simplifiedcoding.data.repository.AuthRepository
import net.simplifiedcoding.data.responses.HomeResponse
import net.simplifiedcoding.data.responses.LoginResponse
import net.simplifiedcoding.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _book: MutableLiveData<Resource<HomeResponse>> = MutableLiveData()
    val book: LiveData<Resource<HomeResponse>>
        get() = _book

    fun getBook() = viewModelScope.launch {
        _book.value = Resource.Loading
        _book.value = repository.getBook()
    }

}