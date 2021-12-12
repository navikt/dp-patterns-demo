package no.nav.dagpenger.patterns.nullobject.user

/*
fun main() {
    val userRepository = UserRepository()
    val user = userRepository.getUserBy(id = 1)

    if(user != null) { //Conditional kan forenkles. user != null vil alltid være sann
        println("Welcome $user")
    } else {
        println("Welcome guest!")
    }
}

class UserRepository {
    private val users = mutableListOf(
        User(1, "Kari"),
        User(2, "Roar")
    )

    fun getUserBy(id: Int) = users.find { user -> user.id == id } ?: GuestUser //Kan ikke lenger returnere null
}

open class User(val id: Int, val name: String)  {
    override fun toString() = name
}

object GuestUser : User(id = -1, name = "Guest") //Singleton objekt med felles navn og id for alle gjestebrukere
*/
