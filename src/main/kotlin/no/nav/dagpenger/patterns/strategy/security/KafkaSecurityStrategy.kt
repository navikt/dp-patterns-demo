package no.nav.dagpenger.patterns.strategy.security

import no.nav.dagpenger.patterns.strategy.security.SslStrategy.EnvironmentKeys.SSL_KEYSTORE_LOCATION
import no.nav.dagpenger.patterns.strategy.security.SslStrategy.EnvironmentKeys.SSL_KEYSTORE_PASSWORD
import no.nav.dagpenger.patterns.strategy.security.SslStrategy.EnvironmentKeys.SSL_TRUSTSTORE_LOCATION
import no.nav.dagpenger.patterns.strategy.security.SslStrategy.EnvironmentKeys.SSL_TRUSTSTORE_PASSWORD
import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.common.config.SaslConfigs
import org.apache.kafka.common.config.SslConfigs
import org.apache.kafka.common.security.auth.SecurityProtocol

class KafkaConfig {
    //Vanlig kafka konfig med brokers, schema registry etc.

    interface SecurityStrategy {
        fun securityConfig(): Map<String, String>
    }
}

//Brukt til testing med kafka embedded env
//Denne sikkerhetsstrategien er uautentisert og ukryptert
internal class PlaintextStrategy : KafkaConfig.SecurityStrategy {

    override fun securityConfig() = mapOf(
        CommonClientConfigs.SECURITY_PROTOCOL_CONFIG to SecurityProtocol.PLAINTEXT.name
    )

}

//Brukt til å koble til kafka on-prem
class SaslSslStrategy(environment: Map<String, String> = System.getenv()) : KafkaConfig.SecurityStrategy {
    private val saslJaasConfig = createPlainLoginModule(
        environment[KAFKA_USERNAME]!!,
        environment[KAFKA_PASSWORD]!!
    )

    override fun securityConfig() = mapOf(
        CommonClientConfigs.SECURITY_PROTOCOL_CONFIG to SecurityProtocol.SASL_SSL.name,
        SaslConfigs.SASL_MECHANISM to "PLAIN",
        SaslConfigs.SASL_JAAS_CONFIG to saslJaasConfig
    )

    private fun createPlainLoginModule(username: String, password: String) =
        """org.apache.kafka.common.security.plain.PlainLoginModule required username="$username" password="$password";"""

    private companion object EnvironmentKeys {
        const val KAFKA_USERNAME = "KAFKA_USERNAME"
        const val KAFKA_PASSWORD = "KAFKA_PASSWORD"
    }
}

//Brukt til å koble til kafka Aiven
internal class SslStrategy(environment: Map<String, String> = System.getenv()) : KafkaConfig.SecurityStrategy {

    private val sslKeystoreLocation = environment[SSL_KEYSTORE_LOCATION]!!
    private val sslKeystorePassword = environment[SSL_KEYSTORE_PASSWORD]!!
    private val sslTruststoreLocation = environment[SSL_TRUSTSTORE_LOCATION]!!
    private val sslTruststorePassword = environment[SSL_TRUSTSTORE_PASSWORD]!!
    private val javaKeystore = "jks"
    private val keystoreType = "PKCS12"

    override fun securityConfig() = mapOf(
        CommonClientConfigs.SECURITY_PROTOCOL_CONFIG to SecurityProtocol.SSL.name,
        SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG to "", //Disable server host name verification
        SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG to javaKeystore,
        SslConfigs.SSL_KEYSTORE_TYPE_CONFIG to keystoreType,
        SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG to sslTruststoreLocation,
        SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG to sslTruststorePassword,
        SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG to sslKeystoreLocation,
        SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG to sslKeystorePassword,
        SslConfigs.SSL_KEY_PASSWORD_CONFIG to sslKeystorePassword
    )

    private object EnvironmentKeys {
        const val SSL_TRUSTSTORE_LOCATION = "KAFKA_TRUSTSTORE_PATH"
        const val SSL_TRUSTSTORE_PASSWORD = "KAFKA_CREDSTORE_PASSWORD"
        const val SSL_KEYSTORE_LOCATION = "KAFKA_KEYSTORE_PATH"
        const val SSL_KEYSTORE_PASSWORD = "KAFKA_CREDSTORE_PASSWORD"
    }
}
