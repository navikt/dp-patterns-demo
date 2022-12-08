package no.nav.dagpenger.patterns.accounting.hendelse

import no.nav.dagpenger.patterns.accounting.Kontonummer
import no.nav.dagpenger.patterns.accounting.postering.IPostering
import java.time.LocalDateTime

interface Hendelse {

    fun nyHendelse(
        hendelseType: HendelseType,
        kontonummer: Kontonummer,
        oppstått: LocalDateTime,
        oppdaget: LocalDateTime
    ): Hendelse

    fun hendelseType(): HendelseType
    fun kontonummer(): Kontonummer
    fun oppstått(): LocalDateTime
    fun oppdaget(): LocalDateTime

    fun erBehandlet(): Boolean
    fun posteringer(): Set<IPostering>
    fun leggTilPostering(postering: IPostering)
}


