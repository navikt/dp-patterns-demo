package no.nav.dagpenger.patterns.state.iverksetting

import java.lang.RuntimeException

fun main() {
    val iverksetting = Iverksetting()
}

class Iverksetting private constructor(private val tilstand: Tilstand) {

    constructor() : this(tilstand = TilUtbetaling)

    interface Tilstand {
        val tilstandType: Type

        fun entering() {}

        fun håndter(vedtakFattetHendelse: VedtakFattetHendelse) {
            hendelseIkkeHåndtert(vedtakFattetHendelse)
        }

        fun håndter(utbetalingsinformasjonSendtHendelse: UtbetalingsinformasjonSendtHendelse) {
            hendelseIkkeHåndtert(utbetalingsinformasjonSendtHendelse)
        }
    }

    object TilUtbetaling : Tilstand {
        override val tilstandType = Type.TilUtbetaling

        override fun entering() {

        }

        override fun håndter(utbetalingsinformasjonSendtHendelse: UtbetalingsinformasjonSendtHendelse) {

        }

    }

    object HentBrev : Tilstand {
        override val tilstandType = Type.HenterBrev
    }

    object SendBrev : Tilstand {
        override val tilstandType = Type.SenderBrev
    }

    object Ferdig : Tilstand {
        override val tilstandType = Type.SenderBrev

        override fun entering() {
            println("Ferdig!")
        }
    }

    enum class Type {
        TilUtbetaling,
        HenterBrev,
        SenderBrev,
        Ferdig
    }
}

fun hendelseIkkeHåndtert(søknadMottatt: Hendelse) {
    throw StateIkkeHåndtert("${søknadMottatt.javaClass.simpleName} er ikke håndtert i denne tilstanden")
}

class StateIkkeHåndtert(message: String) : RuntimeException(message)


