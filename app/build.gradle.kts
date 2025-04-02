plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.coffeecounter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coffeecounter"
        minSdk = 23
        manifestPlaceholders.putAll(
            mapOf(
                "redirectHostName" to "localhost",
                "redirectSchemeName" to "coffee" 
            )
        )
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-Xjvm-default=all"
        )
    }
    
    kotlin {
        jvmToolchain(17) // Use Java 17 toolchain
    }
    
    kapt {
        useBuildCache = true
        javacOptions {
            option("--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED")
            option("--add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED") 
            option("--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED")
            option("--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED")
            option("--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED")
            option("--add-exports=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED")
            option("--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED")
            option("--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED")
            option("--add-opens=jdk.compiler/com.sun.tools.javac.comp=ALL-UNNAMED")
        }
    }
    
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":feature-phone"))
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.3")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.room:room-runtime:2.6.0")
    implementation("androidx.room:room-ktx:2.6.0")
    kapt("androidx.room:room-compiler:2.6.0")
    
    // Web API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.spotify.android:auth:2.1.1") // Spotify SDK

    testImplementation("junit:junit:4.13.2")
}