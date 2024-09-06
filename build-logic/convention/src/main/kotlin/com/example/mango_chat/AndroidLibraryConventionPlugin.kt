package com.example.mango_chat

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }


            extensions.configure<LibraryExtension> {


                defaultConfig{
                    minSdk = 24
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }

                testOptions.targetSdk = 34
                testOptions.animationsDisabled = true


                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    sourceCompatibility = JavaVersion.VERSION_17
                }


                buildTypes{
                    release {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }

            dependencies.apply {
            }
        }

    }
}