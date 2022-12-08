package no.nav.dagpenger.patterns.accounting.postering

import no.nav.dagpenger.patterns.accounting.Penger
import java.time.LocalDateTime

interface Postering {
    fun nyPostering(costType: CostType, prosjekt: Prosjekt, mengde: Penger, dato: LocalDateTime): Postering
    fun getCostType(): CostType
    fun prosjekt(): Prosjekt
    fun mengde(): Penger
    fun avtaleDato(): LocalDateTime
}

class CostType

class Prosjekt