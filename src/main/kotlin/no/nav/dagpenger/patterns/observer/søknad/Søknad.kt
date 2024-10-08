package no.nav.dagpenger.patterns.observer.søknad

import java.time.LocalDateTime
import java.util.UUID

fun main() {
    val søknad = Søknad().also { søknad ->
        //Legg til alle observere
        søknad.addObserver(SøknadLogger)
        søknad.addObserver(SøknadSlettetVarsler())
        søknad.addObserver(SøknadInnsendtStatistikk())
    }
    søknad.sendInn()
    søknad.slett()
}

internal class Søknad private constructor(private val uuid: UUID) {
    constructor() : this(UUID.randomUUID())

    private val observers = mutableListOf<SøknadObserver>()

    fun sendInn() {
        //innsendingslogikk gjøres her
        notifySubscribers()
    }


    fun slett() {
        //sletting foregår her
        observers.forEach { it.søknadSlettet(uuid) }
    }

    private fun notifySubscribers() {
        observers.forEach { it.søknadInnsendt(uuid, LocalDateTime.now()) }
    }
    internal fun addObserver(observer: SøknadObserver) = observers.add(observer)
}
