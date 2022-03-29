plugins {
    java
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClass.set("Main")
}

val resPath = projectDir.absolutePath + "/src/main/resources"
tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
    destinationDirectory.set(file(resPath))
    archiveFileName.set("task9_gradle.jar")
}

