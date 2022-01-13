package no.nav.dagpenger.patterns.visitor.shapes

interface Shape {
    fun accept(visitor: Visitor)
}

class Dot(private val x: Int, private val y: Int) : Shape {

    override fun accept(visitor: Visitor) {
        visitor.visitDot(this)
    }

}

class Rectangle(private val length: Int, private val width: Int) : Shape {

    override fun accept(visitor: Visitor) {
        visitor.visitRectangle(this)
    }
}

class Circle : Shape {

    override fun accept(visitor: Visitor) {
        visitor.visitCircle(this)
    }
}