package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.hendelse.HendelseType
import no.nav.dagpenger.patterns.accounting.postering.Postering
import java.time.LocalDateTime

class RegnskapHendelse(
    private val hendelseType: HendelseType,
    private val oppstått: LocalDateTime,
    private val oppdaget: LocalDateTime,
    private val kunde: Kunde
) {
    private val resulterendePosteringer = HashSet<Postering>()

    fun kunde() = kunde

    fun hendelseType() = hendelseType

    fun oppstått() = oppstått

    fun oppdaget() = oppdaget

    fun leggTilPostering(postering: Postering) {
        resulterendePosteringer.add(postering)
    }

    fun finnRegel(): Posteringsregel? = null  /*discussed later*/

    //TODO: Oversett
    fun process() {} /*discussed later*/
}

class Kunde
class Posteringsregel