plugins {
    kotlin("jvm") version "2.0.20"
    id("org.jetbrains.dokka") version "1.9.20"
}

group = "dev.carloscy"
version = ""

repositories {
    mavenCentral()
}

dependencies {
    // Librerías para Logging
    implementation("org.lighthousegames:logging:1.5.0") // Librería de Logging
    implementation("ch.qos.logback:logback-classic:1.5.12") // Implementación de Logback

    // Mordant
    implementation("com.github.ajalt.mordant:mordant:2.2.0")
    implementation("net.java.dev.jna:jna:5.13.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.jar {
    manifest {
        // definimos el punto de entrada del manifest
        // Es la clase que contiene el main que queremos ejecutar
        // Recuerda que no se pone el punto del fichero, si no en mayusuculas
        // Tampoco se pone .class
        attributes["Main-Class"] = "dev.carloscy.MainKt"
    }
    // Añadimos las dependencias de compilación al jar
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    // configuramos la estrategia de duplicados
    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    archiveFileName.set("starWars.jar")
}