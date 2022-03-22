plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.RequiresOptIn")
}

dependencies {
    implementation(libs.androidx.core)
    testImplementation(libs.junit.junit)
}

afterEvaluate {
    publishing {
        publications {
            repositories.maven {
                url = uri("$rootDir/repository")
            }
            create<MavenPublication>("maven") {
                artifact(file("${project.buildDir}/outputs/aar/view-release.aar"))
                version = "1.2.0"
                groupId = "jp.co.fuller"
                artifactId = "yakan.view"
            }
        }
    }
}
