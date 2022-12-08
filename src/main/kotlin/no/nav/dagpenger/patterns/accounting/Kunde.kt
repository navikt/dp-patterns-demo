package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.postering.Postering

class Kunde(private val navn: String){

    private var tjenesteAvtale: TjenesteAvtale? = null
    private val posteringer = mutableListOf<Postering>()

    fun leggTil(postering: Postering){
        posteringer.add(postering)
    }

    fun hentPosteringer() = listOf(posteringer)

    fun leggTil(tjenesteAvtale: TjenesteAvtale){
        this.tjenesteAvtale = tjenesteAvtale
    }

    fun tjenesteAvtale() = tjenesteAvtale
}
