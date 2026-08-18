plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version libs.versions.kotlin.get()
    id("org.jetbrains.dokka") version "2.2.0"
}

allprojects {
    group = "io.github.version-ops"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}
