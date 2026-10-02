Skip to content
mehdiaskari45-cyber
ma-va-shahid-gomnam
Repository navigation
Code
Issues
Pull requests
Actions
Projects
Wiki
Security and quality
ma-va-shahid-gomnam/app
/build.gradle.kts
Go to file
t
T
mehdiaskari45-cyber
mehdiaskari45-cyber
Create build.gradle.kts
6d07c46
 · 
32 minutes ago

Code

Blame
35 lines (30 loc) · 912 Bytes
Older
Newer
mehdiaskari45-cyber
32 minutes ago

Create build.gradle.kts
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.example.shahidgomnam"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.shahidgomnam"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}
dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.activity:activity-compose:1.10.0")
    implementation("androidx.compose.ui:ui:1.7.6")
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.6")
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.6")
}
