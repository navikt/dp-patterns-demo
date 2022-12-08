package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.postering.MultipliserMedSatsPR
import no.nav.dagpenger.patterns.accounting.postering.PosteringType
import no.nav.dagpenger.patterns.accounting.postering.Posteringsregel
import java.time.LocalDateTime

class TemporalCollection {
    fun put(gyldigFra: LocalDateTime, posteringsregel: Posteringsregel) {
        TODO("Not yet implemented")
    }

    fun get(forDato: LocalDateTime) : Posteringsregel {
        return MultipliserMedSatsPR(PosteringType.grunnforbruk)
    }
}