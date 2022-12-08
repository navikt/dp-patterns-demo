package no.nav.dagpenger.patterns.accounting.postering

import no.nav.dagpenger.patterns.accounting.Penger
import java.time.LocalDateTime

interface IPostering {
    fun nyPostering(kostnadstype: Kostnadstype, prosjekt: Prosjekt, mengde: Penger, dato: LocalDateTime): IPostering
    fun kostnadstype(): Kostnadstype
    fun prosjekt(): Prosjekt
    fun mengde(): Penger
    fun avtaleDato(): LocalDateTime
}

class Kostnadstype

class Prosjekt