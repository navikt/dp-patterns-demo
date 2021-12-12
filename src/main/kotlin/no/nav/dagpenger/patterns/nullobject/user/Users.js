
//Vesentlig enklere å glemme null safety i utypa språk
class User {
    constructor(id, name) {
        this.id = id
        this.name = name;
    }
}

const users = [
    new User(1, "Kari"),
    new User(2, "Roar")
]

function findUser(id) {
    return users.find(user => user.id === id)
}

const user = findUser(3)

console.log(user.name + " har " + user.id)