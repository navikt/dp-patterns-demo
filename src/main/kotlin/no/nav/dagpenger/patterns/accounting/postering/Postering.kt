package no.nav.dagpenger.patterns.accounting.postering

import no.nav.dagpenger.patterns.accounting.Penger
import java.time.LocalDateTime

interface Postering {
    fun nyPostering(kostnadstype: Kostnadstype, prosjekt: Prosjekt, mengde: Penger, dato: LocalDateTime): Postering
    fun kostnadstype(): Kostnadstype
    fun prosjekt(): Prosjekt
    fun mengde(): Penger
    fun avtaleDato(): LocalDateTime
}

class Kostnadstype

class Prosjekt