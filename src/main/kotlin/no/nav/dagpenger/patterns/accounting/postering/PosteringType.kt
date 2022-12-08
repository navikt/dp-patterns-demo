package no.nav.dagpenger.patterns.accounting.postering

class PosteringType(val navn: String) {
    companion object{
        val grunnforbruk = PosteringType("Grunnforbruk")
        val serviceavgift = PosteringType("Serviceavgift")
    }
}
