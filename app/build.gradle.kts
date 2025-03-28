plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
}

configurations.all {
    exclude(group = "com.android.support")
}

android {
    namespace = "com.example.coffeecounter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coffeecounter"
        minSdk = 23  // Android 6.0 (covers 99%+ devices)
        targetSdk = 34  // Latest Android version
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // AndroidX Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.activity:activity-ktx:1.8.0")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    
    // UI Components
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    
    // Architecture Components
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    
    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.3")

    // Room Database
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    kapt("androidx.room:room-compiler:2.5.2")

    // Spotify with AndroidX support and exclusions
    implementation("com.spotify.android:auth:2.1.0") {
        exclude(group = "com.android.support", module = "support-annotations")
        exclude(group = "com.android.support", module = "support-compat")
    }
    implementation("com.spotify.android:app-remote:0.8.1") {
        exclude(group = "com.android.support")
    }

    // Testing (minimal)
    testImplementation("junit:junit:4.13.2")
}