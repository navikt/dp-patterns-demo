package no.nav.dagpenger.patterns.accounting.postering

import no.nav.dagpenger.patterns.accounting.Penger
import java.time.LocalDateTime

class Postering(private val beløp: Penger, private val dato: LocalDateTime, private val type: PosteringType) : IPostering {

    fun beløp() = beløp
    fun dato() = dato
    fun type() = type
    override fun nyPostering(
        kostnadstype: Kostnadstype,
        prosjekt: Prosjekt,
        mengde: Penger,
        dato: LocalDateTime
    ): IPostering {
        TODO("Not yet implemented")
    }

    override fun kostnadstype(): Kostnadstype {
        TODO("Not yet implemented")
    }

    override fun prosjekt(): Prosjekt {
        TODO("Not yet implemented")
    }

    override fun mengde(): Penger {
        TODO("Not yet implemented")
    }

    override fun avtaleDato(): LocalDateTime {
        TODO("Not yet implemented")
    }
}