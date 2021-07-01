plugins {
    kotlin("jvm") version "1.5.20"
    id("org.jetbrains.dokka") version "1.4.32"
}

group = "com.jackchapman"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed", "standardOut", "standardError")
    }
}
 