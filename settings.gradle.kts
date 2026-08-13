
plugins {

}

rootProject.name = "kotlin-kandy"
include(":kotlin-kandy")


fun ProjectDescriptor.applyGradleKtsBuildFileNames() {
    children.forEach { subproject ->
        subproject.buildFileName = "${subproject.name}.gradle.kts"
        subproject.applyGradleKtsBuildFileNames()
    }
}

rootProject.applyGradleKtsBuildFileNames()

