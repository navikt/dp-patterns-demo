package no.nav.dagpenger.patterns.accounting.postering

import no.nav.dagpenger.patterns.accounting.Penger
import no.nav.dagpenger.patterns.accounting.hendelse.RegnskapHendelse
import no.nav.dagpenger.patterns.accounting.hendelse.ForbrukHendelse

class MultipliserMedSatsPR(posteringType: PosteringType) : Posteringsregel(posteringType) {
    override fun kalkulerBeløp(regnskapHendelse: RegnskapHendelse): Penger {
        val standardforbruk = regnskapHendelse as ForbrukHendelse
        return Penger.dollar(standardforbruk.mengde().antall * standardforbruk.sats()!!)
    }
}