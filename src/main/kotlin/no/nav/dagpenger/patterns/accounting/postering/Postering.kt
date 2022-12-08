package no.nav.dagpenger.patterns.accounting.postering

import no.nav.dagpenger.patterns.accounting.Penger
import java.time.LocalDateTime

class Postering(private val beløp: Penger, private val dato: LocalDateTime, private val type: PosteringType ) {

    fun beløp() = beløp
    fun dato() = dato
    fun type() = type
}