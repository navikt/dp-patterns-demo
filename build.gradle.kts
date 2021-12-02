val kafkaVersion = "2.5.0"

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

}