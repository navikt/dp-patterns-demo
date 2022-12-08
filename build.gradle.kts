val kafkaVersion = "2.5.0"
val junitVersion = "5.9.1"

plugins {
    kotlin("jvm") version "1.6.0"
}

group = "no.nav.dagpenger"
version = "1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.apache.kafka:kafka-clients:$kafkaVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

}