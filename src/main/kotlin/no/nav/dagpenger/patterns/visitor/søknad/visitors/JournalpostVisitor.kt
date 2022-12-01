package no.nav.dagpenger.patterns.visitor.søknad.visitors

import no.nav.dagpenger.patterns.visitor.søknad.Søknad
import no.nav.dagpenger.patterns.visitor.søknad.SøknadVisitor
import java.time.ZonedDateTime
import java.util.UUID

//Samler alle journalpostIder fra innsendingene til søknaden
class JournalpostVisitor(søknad: Søknad) : SøknadVisitor {
    private val journalpostIder = mutableListOf<String>()

    init {
        søknad.accept(this)
    }

    fun journalpostIder() = journalpostIder.toList()

    // Vi trenger kun å visite innsendingen, ettersom vi ikke er interesert i felter på Søknad
    override fun visitInnsending(innsendingId: UUID, innsendt: ZonedDateTime, journalpost: String) {
        journalpostIder.add(journalpost)
    }
}