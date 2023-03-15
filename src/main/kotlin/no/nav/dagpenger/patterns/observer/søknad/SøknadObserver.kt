package no.nav.dagpenger.patterns.observer.søknad

import mu.KotlinLogging
import java.time.LocalDateTime
import java.util.UUID

interface SøknadObserver {
    fun søknadInnsendt(uuid: UUID, innsendtTidspunkt: LocalDateTime) {} //Default tom funksjonskropp så ikke alle må implementere den
    fun søknadSlettet(uuid: UUID) {}
}

class SøknadSlettetVarsler : SøknadObserver {
    override fun søknadSlettet(uuid: UUID) {
        println("Send ut melding til andre systemer som er avhengig av denne informasjonen")
    }
}

object SøknadLogger : SøknadObserver {
    private val logger = KotlinLogging.logger { }

    override fun søknadInnsendt(uuid: UUID, innsendtTidspunkt: LocalDateTime) {
        logger.info { "Søknad med uuid=$uuid ble innsendt $innsendtTidspunkt" }
    }

    override fun søknadSlettet(uuid: UUID) {
        logger.info { "Søknad med uuid=$uuid har blitt slettet" }
    }
}