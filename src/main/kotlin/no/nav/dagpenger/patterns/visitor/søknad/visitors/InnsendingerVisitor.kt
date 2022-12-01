package no.nav.dagpenger.patterns.visitor.søknad.visitors

import no.nav.dagpenger.patterns.visitor.søknad.Søknad
import no.nav.dagpenger.patterns.visitor.søknad.SøknadVisitor
import java.time.ZonedDateTime
import java.util.UUID

// Lager et dto objekt med søknadId, samt alle innsendingIder og tidspunkt for innsending for en gitt søknad
class InnsendingerVisitor(søknad: Søknad) : SøknadVisitor {
    private var søknadId: UUID? = null
    private val innsendinger = mutableListOf<InnsendingerDto>()

    init {
        søknad.accept(this)
    }

    fun søknadInnsendinger() = SøknadInnsendingerDto(søknadId!!, innsendinger)

    override fun visitSøknad(søknadId: UUID, ident: String, opprettet: ZonedDateTime) {
        this.søknadId = søknadId
    }

    override fun visitInnsending(innsendingId: UUID, innsendt: ZonedDateTime, journalpost: String) {
        innsendinger.add(
            InnsendingerDto(innsendingId, innsendt)
        )
    }

    data class SøknadInnsendingerDto(val søknadId: UUID, val innsendinger: List<InnsendingerDto>)
    data class InnsendingerDto(val innsendingId: UUID, val innsendt: ZonedDateTime)
}