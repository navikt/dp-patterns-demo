package no.nav.dagpenger.patterns.accounting.hendelse

import no.nav.dagpenger.patterns.accounting.Kontonummer
import no.nav.dagpenger.patterns.accounting.Penger
import no.nav.dagpenger.patterns.accounting.Leverandør
import no.nav.dagpenger.patterns.accounting.postering.Postering
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
    fun posteringer(): Set<Postering>
    fun leggTilPostering(postering: Postering)
}

interface Salg : Hendelse {
    fun nyttSalg(
        kontonummer: Kontonummer,
        oppstått: LocalDateTime,
        oppdaget: LocalDateTime,
        leverandør: Leverandør,
        mengde: Penger
    ): Salg

    fun leverandør(): Leverandør
    fun mengde(): Penger
}

enum class HendelseType {
    Salg
}