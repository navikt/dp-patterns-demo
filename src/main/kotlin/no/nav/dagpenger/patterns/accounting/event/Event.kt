package no.nav.dagpenger.patterns.accounting.event

import no.nav.dagpenger.patterns.accounting.AccountNumber
import no.nav.dagpenger.patterns.accounting.Money
import no.nav.dagpenger.patterns.accounting.Vendor
import java.time.LocalDateTime

interface Event {

    fun newEvent(
        type: EventType,
        account: AccountNumber,
        whenOccurred: LocalDateTime,
        whenNoticed: LocalDateTime
    ): Event

    fun eventType(): EventType
    fun accountNumber(): AccountNumber
    fun whenOccured(): LocalDateTime
    fun whenNoticed(): LocalDateTime
}

interface Sale : Event {
    fun newSale(
        account: AccountNumber,
        whenOccurred: LocalDateTime,
        whenNoticed: LocalDateTime,
        vendor: Vendor,
        amount: Money
    ): Sale

    fun vendor(): Vendor
    fun getAmount(): Money
}

enum class EventType {
    Sale
}