package com.project.destma

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DestMaApplication : Application() {
    companion object {
        fun getAppContext(): Context {
            TODO("Not yet implemented")
        }
    }
}