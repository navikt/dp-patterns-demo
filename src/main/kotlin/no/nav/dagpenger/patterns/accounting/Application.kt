package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.hendelse.HendelseType
import no.nav.dagpenger.patterns.accounting.postering.MultipliserMedSatsPR
import no.nav.dagpenger.patterns.accounting.postering.PosteringType
import java.time.LocalDateTime


fun main() {
    settStandardforbruk("Tonje")
}

private fun settStandardforbruk(navn: String) {
    val kunde = Kunde(navn)
    val standardAvtale = TjenesteAvtale()
    val dato = LocalDateTime.now()
    standardAvtale.setSats(10.0)
    standardAvtale.leggTilPosteringsregel(
        hendelseType = HendelseType.forbruk,
        posteringsregel = MultipliserMedSatsPR(PosteringType.grunnforbruk),
        dato
    )
    kunde.leggTil(standardAvtale)
    println("Kundens navn er $navn")
    println("Kunden har en avtale med sats ${standardAvtale.sats()}")
    //TODO println("Posteringsregel er ${standardAvtale.posteringsregel(dato,HendelseType.forbruk).toString()}")
}
