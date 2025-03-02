plugins {
    id("java")
    id("maven-publish")
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

    publish {
        dependsOn(shadowJar)
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

publishing {
    publications {
        create<MavenPublication>("PLib") {
            from(components["java"])
            groupId = "fr.plhume.plib"
            artifactId = "plib"
            version = "1.1"
        }
    }
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/Plhume/PLib")
            credentials {
                username = (project.findProperty("gpr.user") ?: System.getenv("USERNAME")) as String?
                password = (project.findProperty("gpr.token") ?: System.getenv("TOKEN")) as String?
            }
        }
    }
}
