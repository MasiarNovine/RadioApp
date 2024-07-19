package com.example.radioapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
This is a simple showcase app, implementing a simple radio service based on Android Automotive
grounded on a Kotlin-only premise, i.e. using Kotlin as the sole language, Kotlin DSL for Gradle builds,
Koin for dependency injection (DI) and Kotlin Multiplatform for cross OS implementation
of the app. The UI is based on Jetpack's Compose API for fast development.

Koin: Koin is a dependency injection framework, which takes care of providing dependencies by
creating and wiring the objects based on the dependency declaration. This is done by providing
modules, which specify how to create objects of a specific type. In case an object is needed,
Koin looks up the module and creates the object. One important point is, that Koin scopes modules
to the specific domain, which is needed and in does not follow the approach of defining the
objects as static global objects, which improves testability and makes the code logic more
transparent.

Some pros and cons

pros:
* presumably faster to learn than Hilt
* lightweight DSL
* transparent code, no compile time code generation, hence faster build times
* compatible with Kotlin Multiplatform
* compatible with Compose

cons:
* no compile check of dependency graph
* presumable some minor performance trade-off
* does not have the rich documentation support of Android Developers

alternatives: Hilt (annotation based, runtime-save), Kodein, manual dependency injection

## Background on Koin

Koin provides a Domain specific language (DSL)
* Application DSL: describing the Koin container configuration
* Module DSL: describing the components, that have been injected
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Replace the setContenView with setContent of Jetpacks Compose API

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}