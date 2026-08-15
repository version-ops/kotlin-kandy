
plugins {

}

rootProject.name = "kotlin-kandy"
include(":kandy-core")


fun ProjectDescriptor.applyGradleKtsBuildFileNames() {
    children.forEach { subproject ->
        subproject.buildFileName = "${subproject.name}.gradle.kts"
        subproject.applyGradleKtsBuildFileNames()
    }
}

rootProject.applyGradleKtsBuildFileNames()

