buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        // workaround for version catalogue
        // https://github.com/gradle/gradle/issues/16958
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs") as org.gradle.accessors.dm.LibrariesForLibs

        classpath(libs.android.gradle)
        classpath(libs.kotlin.gradle)
        classpath(libs.ktlint.gradle)
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}