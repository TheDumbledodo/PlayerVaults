plugins {
    java
    id("com.gradleup.shadow") version "8.3.5"
}

group = "dev.dumble.vaults"
version = "0.1"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://jitpack.io")
    maven("https://projectlombok.org/edge-releases")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.codemc.io/repository/maven-releases/")
    maven("https://repo.aikar.co/content/groups/aikar/")
}

dependencies {

    // Lombok
    compileOnly("org.projectlombok:lombok:edge-SNAPSHOT")
    annotationProcessor("org.projectlombok:lombok:edge-SNAPSHOT")

    // Paper
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")

    // ACF
    implementation("co.aikar:acf-paper:0.5.1-SNAPSHOT")

    compileOnly("supervisor:configuration:1.0.2")
    compileOnly("supervisor:core:1.0.2")
    compileOnly("supervisor:menu:1.0.2")
    compileOnly("supervisor:util:1.0.2")
    compileOnly("supervisor:yaml-configuration:1.0.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.shadowJar {
     destinationDirectory.set(file("$rootDir/jars"))

    archiveFileName.set("PlayerVaults-${project.version}.jar")
}