package no.nav.dagpenger.patterns.accounting.hendelse

import no.nav.dagpenger.patterns.accounting.Kunde
import no.nav.dagpenger.patterns.accounting.postering.IPostering
import no.nav.dagpenger.patterns.accounting.postering.Posteringsregel
import java.time.LocalDateTime

open class RegnskapHendelse(
    private val hendelseType: HendelseType,
    private val oppstått: LocalDateTime,
    private val oppdaget: LocalDateTime,
    private val kunde: Kunde
) {
    private val resulterendePosteringer = HashSet<IPostering>()

    fun kunde() = kunde

    fun hendelseType() = hendelseType

    fun oppstått() = oppstått

    fun oppdaget() = oppdaget

    fun leggTilResulterendePostering(postering: IPostering) {
        resulterendePosteringer.add(postering)
    }

    fun finnRegel(): Posteringsregel{
        val regel  = kunde.tjenesteAvtale()?.posteringsregel(hendelseType = hendelseType, forDato = oppstått)
        requireNotNull(regel) { "Manglende posteringsregel" }
        return regel
    }

    fun process() {
        finnRegel().prosesser(this)
    }
}
