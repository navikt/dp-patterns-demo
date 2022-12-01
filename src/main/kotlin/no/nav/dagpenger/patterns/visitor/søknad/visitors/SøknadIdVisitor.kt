package no.nav.dagpenger.patterns.visitor.søknad.visitors

import no.nav.dagpenger.patterns.visitor.søknad.Søknad
import no.nav.dagpenger.patterns.visitor.søknad.SøknadVisitor
import java.time.ZonedDateTime
import java.util.UUID

class SøknadIdVisitor(søknad: Søknad) : SøknadVisitor {
    private var søknadId: UUID? = null

    init {
        søknad.accept(this)
    }

    fun søknadId() = søknadId!!

    override fun visitSøknad(søknadId: UUID, ident: String, opprettet: ZonedDateTime) {
        this.søknadId = søknadId
    }
}