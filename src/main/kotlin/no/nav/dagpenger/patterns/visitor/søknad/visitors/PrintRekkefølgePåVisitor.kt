package no.nav.dagpenger.patterns.visitor.søknad.visitors

import no.nav.dagpenger.patterns.visitor.søknad.Søknad
import no.nav.dagpenger.patterns.visitor.søknad.SøknadVisitor
import java.time.ZonedDateTime
import java.util.UUID

class PrintRekkefølgePåVisitor(søknad: Søknad) : SøknadVisitor {
    init {
        søknad.accept(this)
    }

    override fun previsitSøknad() {
        println("previsitSøknad: Jeg blir kalt som nr 1")
    }

    override fun visitSøknad(søknadId: UUID, ident: String, opprettet: ZonedDateTime) {
        println("visitSøknad: Jeg blir kalt som nr 2")
    }

    override fun preVisitInnsending() {
        println("previsitInnsending: Jeg blir kalt for hver innsending!")
    }

    override fun visitInnsending(innsendingId: UUID, innsendt: ZonedDateTime, journalpost: String) {
        println("visitInnsending: Jeg blir kalt for hver innsending!")
    }

    override fun postVisitInnsending() {
        println("postvisitInnsending: Jeg blir kalt for hver innsending!")
    }

    override fun postvisitSøknad() {
        println("postvisitSøknad: Jeg blir kalt helt til slutt!")
    }
}