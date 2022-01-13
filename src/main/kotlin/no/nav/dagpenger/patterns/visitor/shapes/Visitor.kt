package no.nav.dagpenger.patterns.visitor.shapes


interface Visitor {
    fun visitDot(dot: Dot)
    fun visitCircle(circle: Circle)
    fun visitRectangle(rectandle: Rectangle)
}