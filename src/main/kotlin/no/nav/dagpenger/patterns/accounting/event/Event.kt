package no.nav.dagpenger.patterns.accounting.event

import no.nav.dagpenger.patterns.accounting.AccountNumber
import java.time.LocalDateTime

abstract class Event(
    private val eventType: EventType,
    private val accountNumber: AccountNumber,
    private val whenOccured: LocalDateTime,
    private val whenNoticed: LocalDateTime
) {
    fun eventType() = eventType
    fun accountNumber() = accountNumber
    fun whenOccured() = whenOccured
    fun whenNoticed() = whenNoticed
}

enum class EventType {
    Sale
}