plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Essential plugins for Room:
    id("kotlin-kapt")                   // For Kotlin annotation processing
    id("kotlin-parcelize")               // To use Kotlin's parcelize feature
//    id("androidx.room")                  // Optional: for versioned Room plugin configuration
//    id("com.google.devtools.ksp") version "2.0.21-1.0.25"  // KSP version for Kotlin symbol processing
//    id("androidx.navigation.safeargs")
//    id("androidx.navigation.safeargs.kotlin")


}

android {
    namespace = "com.example.databaseapp3"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.databaseapp3"
        minSdk = 33
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



//    room {
//        schemaDirectory("$projectDir/schemas")  // Generates schema JSON for migrations
//    }
}

dependencies {
    // Core dependencies
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    val room_version = "2.6.1"  // Room version for all dependencies

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    // Room dependencies
    implementation("androidx.room:room-runtime:$room_version")             // Core Room library
    kapt("androidx.room:room-compiler:$room_version")                      // Annotation processor for Room
     kapt("androidx.room:room-compiler:$room_version")                    // Uncomment for KSP support

    // Optional Room dependencies
    implementation("androidx.room:room-ktx:$room_version")                 // Kotlin Coroutines support
    implementation("androidx.room:room-rxjava2:$room_version")             // RxJava2 support
    implementation("androidx.room:room-rxjava3:$room_version")             // RxJava3 support
    implementation("androidx.room:room-guava:$room_version")               // Guava support
    testImplementation("androidx.room:room-testing:$room_version")         // Test helpers
    implementation("androidx.room:room-paging:$room_version")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // more
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3") //
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
//    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.3")
//    kapt("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-beta01")
    kapt("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.4")
//    implementation ("android.arch.navigation:navigation-fragment-ktx:2.7.4")
//    implementation ("android.arch.navigation:navigation-ui-ktx:2.7.4")

}
