package no.nav.dagpenger.patterns.accounting

import no.nav.dagpenger.patterns.accounting.postering.Postering
import no.nav.dagpenger.patterns.accounting.postering.PosteringType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class KundeTest {

    @Test
    fun `Skal kunne opprette kunde`(){
        val kunde = Kunde("Kunde Kundesen")
        kunde.leggTil(TjenesteAvtale())
        kunde.leggTil(Postering(Penger(), LocalDateTime.now(), PosteringType.grunnforbruk))

        assertNotNull(kunde.tjenesteAvtale())
        assertEquals(1, kunde.hentPosteringer().size)

    }
}