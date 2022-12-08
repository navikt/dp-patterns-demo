package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.hendelse.HendelseType
import no.nav.dagpenger.patterns.accounting.hendelse.Mengde
import no.nav.dagpenger.patterns.accounting.hendelse.StandardForbruk
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class StandardForbrukTest {

    @Test
    fun `Kan forbruke`() {

        val kunde = Kunde("Kunde Kundesen").let { kunde ->
            TjenesteAvtale().let {
                it.setSats(1.1)
                kunde.leggTil(it)
            }
        }

        val standardForbruk = StandardForbruk(
            Mengde(),
            HendelseType.forbruk,
            LocalDateTime.now(),
            LocalDateTime.now(),
            kunde
        )
    }
}