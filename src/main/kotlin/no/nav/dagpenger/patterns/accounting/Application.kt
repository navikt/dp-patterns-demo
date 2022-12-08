package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.hendelse.HendelseType
import no.nav.dagpenger.patterns.accounting.postering.MultipliserMedSatsPR
import no.nav.dagpenger.patterns.accounting.postering.PosteringType
import java.time.LocalDateTime

class Application {
    fun main() {
        settStandardforbruk("Tonje")
    }

    private fun settStandardforbruk(navn: String) {
        val kunde = Kunde(navn)
        val standardAvtale = TjenesteAvtale()
        standardAvtale.setSats(10.0)
        standardAvtale.leggTilPosteringsregel(
            hendelseType = HendelseType.forbruk,
            posteringsregel = MultipliserMedSatsPR(PosteringType.grunnforbruk),
            LocalDateTime.now()
        )
        kunde.leggTil(standardAvtale)
    }
}