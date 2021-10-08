buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // workaround for version catalogue
        // https://github.com/gradle/gradle/issues/16958
        // val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs") as org.gradle.accessors.dm.LibrariesForLibs

        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}
