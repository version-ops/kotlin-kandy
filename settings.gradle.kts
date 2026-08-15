rootProject.name = "kotlin-kandy"
include(":kandy-core")

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}


fun ProjectDescriptor.applyGradleKtsBuildFileNames() {
    children.forEach { subproject ->
        subproject.buildFileName = "${subproject.name}.gradle.kts"
        subproject.applyGradleKtsBuildFileNames()
    }
}

rootProject.applyGradleKtsBuildFileNames()

