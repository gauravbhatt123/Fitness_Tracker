plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.pogo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pogo"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    // Core libraries
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    // Firebase BoM (Bill of Materials) - Manages Firebase versions
    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
    // Firebase Authentication
    implementation("com.google.firebase:firebase-auth")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    // Google Play services for Google Sign-In
    implementation("com.google.android.gms:play-services-auth:21.3.0")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    implementation ("com.mikhaellopez:circularprogressbar:3.1.0")
    implementation("com.github.Dimezis:BlurView:version-2.0.6")
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
