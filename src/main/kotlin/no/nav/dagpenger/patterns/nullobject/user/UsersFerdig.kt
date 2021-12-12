package no.nav.dagpenger.patterns.nullobject.user
/*
fun main() {
    val userRepository = UserRepository()
    val user = userRepository.getUserBy(id = 1)

    println("Welcome $user") //nullsjekk ikke lenger nødvendig

}

class UserRepository {
    private val users = mutableListOf(
        User(1, "Kari"),
        User(2, "Roar")
    )

    fun getUserBy(id: Int) = users.find { user -> user.id == id } ?: GuestUser //Kan ikke lenger returnere null, så if else blir overflødig
}

open class User(val id: Int, val name: String)  {
    override fun toString() = name
}

object GuestUser : User(id = -1, name = "Guest")
*/