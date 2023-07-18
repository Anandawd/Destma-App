package com.project.destma.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.project.destma.domain.repository.AuthRepository
import com.project.destma.utils.Resource
import com.project.destma.utils.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _signInState = Channel<SignInState>()
    val signInState = _signInState.receiveAsFlow()

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    fun logout() = viewModelScope.launch{
        repository.logoutUser().collect{result ->
            when(result){
                is Resource.Success -> {
                    _signInState.send(SignInState(isSuccess = "Logout Success"))
                }
                is Resource.Loading -> {
                    _signInState.send(SignInState(isLoading = true))
                }
                is Resource.Error -> {
                    _signInState.send(SignInState(isError = result.message))
                }
            }
        }
    }
}