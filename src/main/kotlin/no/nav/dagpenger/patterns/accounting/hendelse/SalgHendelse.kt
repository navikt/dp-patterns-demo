package no.nav.dagpenger.patterns.accounting.hendelse

import no.nav.dagpenger.patterns.accounting.Kontonummer
import no.nav.dagpenger.patterns.accounting.Leverandør
import no.nav.dagpenger.patterns.accounting.Penger
import java.time.LocalDateTime

interface SalgHendelse : Hendelse {

    fun nyttSalg(
        kontonummer: Kontonummer,
        oppstått: LocalDateTime,
        oppdaget: LocalDateTime,
        leverandør: Leverandør,
        mengde: Penger
    ): SalgHendelse

    fun leverandør(): Leverandør
    fun mengde(): Penger
}
