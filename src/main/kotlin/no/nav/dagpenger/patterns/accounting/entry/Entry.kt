package no.nav.dagpenger.patterns.accounting.entry

import no.nav.dagpenger.patterns.accounting.Money
import java.time.LocalDateTime

interface Entry {
    fun newEntry(costType: CostType, project: Project, amount: Money, date: LocalDateTime): Entry
    fun getCostType(): CostType
    fun getProject(): Project
    fun getAmount(): Money
    fun getBookingDate(): LocalDateTime
}

class CostType

class Project