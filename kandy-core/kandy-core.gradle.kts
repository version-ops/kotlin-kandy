
plugins {
    kotlin("jvm")
    `java-library`
    `maven-publish`
    id("org.jetbrains.dokka")
}

dependencies {

    testImplementation(libs.bundles.kotest)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Apply a specific Java toolchain to ease working on diffesrent environments.
java {
    withSourcesJar()
    withJavadocJar()
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.named<Jar>("javadocJar") {
    from(tasks.named("dokkaGeneratePublicationHtml"))
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
//            artifact(javadocJar)
        }
    }
}
