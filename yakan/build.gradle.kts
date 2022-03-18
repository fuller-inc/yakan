plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30
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
    testImplementation(libs.junit.junit)
}

tasks {
    val androidSourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(android.sourceSets["main"].java.srcDirs)
    }
}

afterEvaluate {
    publishing {
        publications {
            repositories.maven {
                url = uri("$rootDir/repository")
            }
            create<MavenPublication>("maven") {
                artifact(tasks["androidSourcesJar"])
                version = "1.2.0"
                groupId = "jp.co.fuller"
                artifactId = "yakan"
            }
        }
    }
}
