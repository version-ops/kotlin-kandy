plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version libs.versions.kotlin.get()
}

allprojects {
    group = "io.github.version-ops"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}
