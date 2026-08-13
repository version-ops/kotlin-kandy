plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version libs.versions.kotlin.get()
}

allprojects {
    group = "io.github.waveskimmer.kotlin"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}
