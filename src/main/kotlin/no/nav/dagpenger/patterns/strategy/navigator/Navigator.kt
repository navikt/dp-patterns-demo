package no.nav.dagpenger.patterns.strategy.navigator


fun main() {
    val navigator = Navigator(WalkingStrategy())
    navigator.printRoute()
}

internal class Navigator(private val routeStrategy: RouteStrategy) : RouteStrategy {
    private val route = routeStrategy.buildRoute()

    override fun buildRoute() = routeStrategy.buildRoute()

    fun printRoute() = print(route)
}

internal interface RouteStrategy {
    fun buildRoute() : String
}


internal class WalkingStrategy : RouteStrategy {
    override fun buildRoute() = "Fastest route by walking"
}

internal class PublicTransportStrategy : RouteStrategy {
    override fun buildRoute() = "Fastest route by public transport"
}

internal class RoadStrategy : RouteStrategy {
    override fun buildRoute() = "Fastest route by main roads"
}
