
plugins {

}

rootProject.name = "kotlin-extensions"
include(":kotlin-extensions")


fun ProjectDescriptor.applyGradleKtsBuildFileNames() {
    children.forEach { subproject ->
        subproject.buildFileName = "${subproject.name}.gradle.kts"
        subproject.applyGradleKtsBuildFileNames()
    }
}

rootProject.applyGradleKtsBuildFileNames()

