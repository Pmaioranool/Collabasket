plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.collabasket"
    compileSdk = 35

    signingConfigs {
        create("testKeystore") {
            storeFile = file("test.keystore.jks")
            storePassword = project.properties["STORE_PASSWORD"] as String
            keyAlias = "TestKey"
            keyPassword = project.properties["KEY_PASSWORD"] as String
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("testKeystore")
        }
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("testKeystore")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    defaultConfig {
        applicationId = "com.example.collabasket"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(platform("com.google.firebase:firebase-bom:33.12.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-auth")

    implementation("com.hbb20:ccp:2.7.1")
    implementation("com.google.firebase:firebase-dynamic-links:20.1.0")
    implementation("com.google.firebase:firebase-messaging:23.4.1")
}

apply(plugin = "com.google.gms.google-services")
