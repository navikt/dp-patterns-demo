package no.nav.dagpenger.patterns.accounting.hendelse

import no.nav.dagpenger.patterns.accounting.Kunde
import no.nav.dagpenger.patterns.accounting.postering.IPostering
import java.time.LocalDateTime

class RegnskapHendelse(
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

    fun leggTilPostering(postering: IPostering) {
        resulterendePosteringer.add(postering)
    }

    fun finnRegel(): Posteringsregel? = null  /*discussed later*/

    //TODO: Oversett
    fun process() {} /*discussed later*/
}

class Posteringsregel