plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version libs.versions.kotlin.get()
    id("pl.allegro.tech.build.axion-release") version "1.21.2"
}
version = scmVersion.version

allprojects {
    group = "io.github.version-ops"
    version = project.version

    repositories {
        mavenLocal()
        mavenCentral()
    }
}
