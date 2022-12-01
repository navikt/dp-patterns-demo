package no.nav.dagpenger.patterns.visitor.søknad

import no.nav.dagpenger.patterns.visitor.søknad.visitors.InnsendingerVisitor
import no.nav.dagpenger.patterns.visitor.søknad.visitors.JournalpostVisitor
import no.nav.dagpenger.patterns.visitor.søknad.visitors.PrintRekkefølgePåVisitor
import no.nav.dagpenger.patterns.visitor.søknad.visitors.SøknadIdVisitor
import java.time.ZonedDateTime
import java.util.UUID

fun main() {
    val søknad = søknadMedInnsendinger()

    println("SøknadIdVisitor: ${SøknadIdVisitor(søknad).søknadId()}")

    println("JournalpostVisitor: ${JournalpostVisitor(søknad).journalpostIder()}")

    println("InnsendingerVisitor: ${InnsendingerVisitor(søknad).søknadInnsendinger()}")

    PrintRekkefølgePåVisitor(søknad)
}

class Søknad(
    private val søknadId: UUID,
    private val ident: String,
    private val opprettet: ZonedDateTime,
    private val innsendinger: List<Innsending>
) {
    fun accept(visitor: SøknadVisitor) {
        visitor.previsitSøknad()
        visitor.visitSøknad(
            søknadId = søknadId,
            ident = ident,
            opprettet = opprettet
        )
        //Siden søknad har innsendinger, så må vi visite de også for å gå nedover i en objektstruktur.
        innsendinger.forEach { innsending ->
            innsending.accept(visitor)
        }
        visitor.postvisitSøknad()
    }
}

class Innsending(
    private val innsendingId: UUID,
    private val innsendt: ZonedDateTime,
    private var journalpostId: String,
) {
    fun accept(visitor: InnsendingVisitor) {
        visitor.preVisitInnsending()
        visitor.visitInnsending(
            innsendingId,
            innsendt,
            journalpostId
        )
        visitor.postVisitInnsending()
    }
}

private fun søknadMedInnsendinger() = Søknad(
    søknadId = UUID.randomUUID(),
    ident = "12345123451",
    opprettet = ZonedDateTime.now(),
    innsendinger = listOf(
        Innsending(
            innsendingId = UUID.randomUUID(),
            innsendt = ZonedDateTime.now(),
            journalpostId = "123"
        ),
        Innsending(
            innsendingId = UUID.randomUUID(),
            innsendt = ZonedDateTime.now(),
            journalpostId = "456"
        )
    )
)
