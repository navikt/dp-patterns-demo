package no.nav.dagpenger.patterns.accounting.hendelse

class HendelseType(navn: String) {
    companion object {
        var forbruk = HendelseType("forbruk")
        var hjelpetelefon = HendelseType("hjelpetelefon")
    }
}