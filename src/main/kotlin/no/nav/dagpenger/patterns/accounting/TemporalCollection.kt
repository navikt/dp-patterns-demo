package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.postering.MultipliserMedSatsPR
import no.nav.dagpenger.patterns.accounting.postering.PosteringType
import no.nav.dagpenger.patterns.accounting.postering.Posteringsregel
import java.time.LocalDate
import java.time.LocalDateTime

class TemporalCollection {

    private val innhold = mutableMapOf<LocalDateTime, Posteringsregel>()

    fun put(gyldigFra: LocalDateTime, posteringsregel: Posteringsregel) {
        innhold[gyldigFra] = posteringsregel
    }

    fun get(forDato: LocalDateTime) : Posteringsregel {
        return MultipliserMedSatsPR(PosteringType.grunnforbruk)
    }
}