package com.project.destma.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.destma.domain.repository.AuthRepository
import com.project.destma.utils.Resource
import com.project.destma.utils.SignInState
import com.project.destma.utils.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _signUpState = Channel<SignUpState>()
    val signUpState = _signUpState.receiveAsFlow()

    private val _signInState = Channel<SignInState>()
    val signInState = _signInState.receiveAsFlow()

    fun registerUser(name: String, email: String, password: String) = viewModelScope.launch {
        repository.registerUser(name, email, password).collect{ result ->
            when(result){
                is Resource.Success -> {
                    _signUpState.send(SignUpState(isSuccess = "Sign Up Success"))
                }
                is Resource.Loading -> {
                    _signUpState.send(SignUpState(isLoading = true))
                }
                is Resource.Error -> {
                    _signUpState.send(SignUpState(isError = result.message))
                }
            }
        }
    }

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect{ result ->
            when(result){
                is Resource.Success -> {
                    _signInState.send(SignInState(isSuccess = "Login Success"))
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