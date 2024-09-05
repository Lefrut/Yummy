pluginManagement {
    includeBuild("build-logic")
    repositories {

        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}

rootProject.name = "mango_chat"
include(":app")
include(":resources")
include(":navigation")
include(":ui")
include(":authorization")
include(":registration")
include(":chat")
include(":chats")
include(":profile")
include(":edit_profile")
include(":data")
include(":domain")
