package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.hendelse.HendelseType
import no.nav.dagpenger.patterns.accounting.hendelse.Posteringsregel
import java.time.LocalDateTime

class TjenesteAvtale {
    private var sats: Double = 0.0
    private val posteringsregler = mutableMapOf<HendelseType, TemporalCollection>()

    fun leggTilPosteringsregel(hendelseType: HendelseType, posteringsregel: Posteringsregel, gyldigFra: LocalDateTime) {
        if (posteringsregler[hendelseType] == null)
            posteringsregler[hendelseType] = TemporalCollection()
        temporalCollection(hendelseType).put(gyldigFra, posteringsregel)
    }

    fun posteringsregel(forDato: LocalDateTime, hendelseType: HendelseType) =
        temporalCollection(hendelseType).get(forDato)

    fun sats() = sats

    fun setSats(sats: Double) {
        this.sats = sats
    }

    private fun temporalCollection(hendelseType: HendelseType): TemporalCollection {
        val resultat = posteringsregler[hendelseType]
        requireNotNull(resultat)
        return resultat
    }
}
