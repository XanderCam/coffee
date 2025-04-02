buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
<<<<<<< HEAD
        classpath("com.android.tools.build:gradle:8.2.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
=======
        classpath("com.android.tools.build:gradle:8.4.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
>>>>>>> fae5d5e317e5121619327069e562d77968bff488
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.3")
    }
}

plugins {
<<<<<<< HEAD
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
=======
    id("com.google.devtools.ksp") version "1.9.22-1.0.17" apply false
>>>>>>> fae5d5e317e5121619327069e562d77968bff488
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(layout.buildDirectory)
}