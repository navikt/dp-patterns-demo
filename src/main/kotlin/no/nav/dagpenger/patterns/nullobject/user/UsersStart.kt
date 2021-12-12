package no.nav.dagpenger.patterns.nullobject.user


fun main() {
    val userRepository = UserRepository()
    val user = userRepository.getUserBy(id = 1)

    //Dette er ikke kult, spesielt dersom det gjøres overalt i koden
    if(user != null) {
        println("Welcome $user!")
    } else {
        println("Welcome guest!")
    }

}

class UserRepository {
    private val users = mutableListOf(
        User(1, "Kari"),
        User(2, "Roar")
    )

    fun getUserBy(id: Int) = users.find { it.id == id }  //Kan returnere null, bør gjøres noe her
}

class User(val id: Int, private val name: String)  {
    override fun toString() = name
    //Flere viktige funksjoner
}