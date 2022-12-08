package no.nav.dagpenger.patterns.accounting.postering

import no.nav.dagpenger.patterns.accounting.Penger
import no.nav.dagpenger.patterns.accounting.hendelse.RegnskapHendelse

abstract class Posteringsregel(val posteringType: PosteringType) {

    fun lagPostering(regnskapHendelse: RegnskapHendelse, beløp: Penger) {
        val postering = Postering(beløp, regnskapHendelse.oppdaget(), posteringType)
        regnskapHendelse.kunde().leggTil(postering)
        regnskapHendelse.leggTilResulterendePostering(postering)
    }

    fun prosesser(regnskapHendelse: RegnskapHendelse) {
        lagPostering(regnskapHendelse, kalkulerBeløp(regnskapHendelse))
    }

    abstract fun kalkulerBeløp(regnskapHendelse: RegnskapHendelse): Penger
}