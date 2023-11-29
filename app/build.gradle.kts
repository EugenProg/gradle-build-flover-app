plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "kz.just_code.gradleflavorsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "kz.just_code.gradleflavorsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

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

    flavorDimensions += "api"
    productFlavors {
        create("prod_") {
            dimension = "api"

            buildConfigField("String", "BASE_MAIN_URL", "\"https://developer.android.com/build/build-variants\"")
            buildConfigField("String", "BUILD_NAME", "\"PROD\"")

            manifestPlaceholders ["appName"] = "Gradle"
            manifestPlaceholders ["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders ["appIconRound"] = "@mipmap/ic_launcher_round"
        }

        create("dev_") {
            dimension = "api"

            buildConfigField("String", "BASE_MAIN_URL", "\"https://developer.android.com\"")
            buildConfigField("String", "BUILD_NAME", "\"DEV\"")

            manifestPlaceholders ["appName"] = "Gradle dev"
            manifestPlaceholders ["appIcon"] = "@mipmap/ic_launcher_dev"
            manifestPlaceholders ["appIconRound"] = "@mipmap/ic_launcher_dev_round"

            applicationIdSuffix = ".dev"
            versionNameSuffix = ".dev"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}