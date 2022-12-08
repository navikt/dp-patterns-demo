package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.hendelse.HendelseType
import no.nav.dagpenger.patterns.accounting.hendelse.Mengde
import no.nav.dagpenger.patterns.accounting.hendelse.ForbrukHendelse
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class ForbrukHendelseTest {

    @Test
    fun `Kan forbruke`() {

        val tjenesteAvtale = TjenesteAvtale()
        tjenesteAvtale.setSats(11.0)
        val kunde = Kunde("Kunde Kundesen")
        kunde.leggTil(tjenesteAvtale)

        val forbrukHendelse = ForbrukHendelse(
            Mengde(10),
            HendelseType.forbruk,
            LocalDateTime.now(),
            LocalDateTime.now(),
            kunde
        )
    }
}