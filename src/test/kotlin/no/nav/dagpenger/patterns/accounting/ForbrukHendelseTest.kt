package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.hendelse.HendelseType
import no.nav.dagpenger.patterns.accounting.hendelse.Mengde
import no.nav.dagpenger.patterns.accounting.hendelse.ForbrukHendelse
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class ForbrukHendelseTest {

    @Test
    fun `Kan forbruke`() {

        val kunde = Kunde("Kunde Kundesen").let { kunde ->
            TjenesteAvtale().let {
                it.setSats(1.1)
                kunde.leggTil(it)
            }
        }

        val forbrukHendelse = ForbrukHendelse(
            Mengde(),
            HendelseType.forbruk,
            LocalDateTime.now(),
            LocalDateTime.now(),
            kunde
        )
    }
}