package com.bhojak.spacex.core.utils

/*
     * Bhupendra Bhojak
     *
     * Hilt needs Application class in the library and we must execute our instrumented test with an application that supports Hilt.
     * As a result, Hilt library has a HiltTestApplication class and would need to configure a new test runner that
     * uses Hilt test application.
     *
     * Also, Add the new test runner in the gradle config block.
*/

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication

@HiltAndroidTest
class HiltTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        name: String?,
        context: Context?,
    ): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}
