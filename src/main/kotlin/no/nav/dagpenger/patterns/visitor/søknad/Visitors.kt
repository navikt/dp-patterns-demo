package no.nav.dagpenger.patterns.visitor.søknad

import java.time.ZonedDateTime
import java.util.UUID

interface SøknadVisitor : InnsendingVisitor {
    fun previsitSøknad() {} //Default tom implementasjon så man ikke trenger å implementere den overalt
    fun visitSøknad(søknadId: UUID, ident: String, opprettet: ZonedDateTime) {}
    fun postvisitSøknad() {}
}

interface InnsendingVisitor {
    fun preVisitInnsending() {}
    fun visitInnsending(innsendingId: UUID, innsendt: ZonedDateTime, journalpost: String) {}
    fun postVisitInnsending() {}
}
