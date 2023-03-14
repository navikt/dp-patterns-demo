package no.nav.dagpenger.patterns.observer.logger

import mu.KotlinLogging
import java.util.UUID

fun main() {
    val sak = Sak("Dagpenger").also {
        it.addObserver(SakLogger)
    }
    sak.startBehandling()
}

class Sak private constructor(private val type: String, private val uuid: UUID) {
    constructor(sakType: String) : this(sakType, UUID.randomUUID())

    private val observers = mutableListOf<SakObserver>()

    internal fun addObserver(sakObserver: SakObserver) = observers.add(sakObserver)

    override fun toString() = "Sak(sakType=$type, uuid=$uuid)"

    fun startBehandling() {
        //noe domenelogikk
        observers.forEach { sakObserver -> sakObserver.startetBehandling(sak = this) }
    }
}

interface SakObserver {
    fun startetBehandling(sak: Sak)
}

object SakLogger : SakObserver {
    private val logger = KotlinLogging.logger { }
    override fun startetBehandling(sak: Sak) {
        logger.info { "Startet behandling av $sak" }
    }
}