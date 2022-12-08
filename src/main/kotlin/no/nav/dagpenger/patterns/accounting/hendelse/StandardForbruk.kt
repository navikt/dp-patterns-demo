package no.nav.dagpenger.patterns.accounting.hendelse

import no.nav.dagpenger.patterns.accounting.Kunde
import java.time.LocalDateTime

class StandardForbruk(
    private val mengde: Mengde,
    type: HendelseType,
    opprettet: LocalDateTime,
    oppdaget: LocalDateTime,
    kunde: Kunde
) : RegnskapHendelse(type, opprettet, oppdaget, kunde) {
    fun mengde() = mengde
    fun sats() = kunde().tjenesteAvtale()?.sats()
}

class Mengde