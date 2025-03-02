plugins {
    id("java")
    alias(libs.plugins.shadow)
}

group = "fr.plhume.plib"
version = "1.1"
description = "Library by Plhume for Plhume"

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    compileOnly(libs.paper)
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    clean {
        delete("run")
    }

    shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
        archiveVersion.set("")
        minimize()
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}