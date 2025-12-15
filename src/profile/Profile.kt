package profile

fun main() {
    val person1 = Person("Nick", "Smith", 167, 68)
    val person2 = Person("Nick", "Smith", 167, 68)
    val person3 = person1.copy(name = "Jhon")
    val people = setOf(person1, person2, person3)
    for (person in people){
        println(person)
    }
}