val kafkaVersion = "2.6.3"
val junitVersion = "5.9.1"
val loggingVersion = "3.0.4"

plugins {
    kotlin("jvm") version "1.6.0"
}

group = "no.nav.dagpenger"
version = "1"

repositories {
    mavenCentral()
}

object Log4j2 {
    const val version = "2.19.0"
    const val api = "org.apache.logging.log4j:log4j-api:$version"
    const val core = "org.apache.logging.log4j:log4j-core:$version"
    const val slf4j = "org.apache.logging.log4j:log4j-slf4j2-impl:$version"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.apache.kafka:kafka-clients:$kafkaVersion")
    implementation(Log4j2.api)
    implementation(Log4j2.core)
    implementation(Log4j2.slf4j)
    implementation("io.github.microutils:kotlin-logging:$loggingVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}