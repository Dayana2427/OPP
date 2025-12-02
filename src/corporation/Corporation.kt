package corporation

fun main () {
    val accountant = Contador(0, "Lucas", 30)
    val director = Director(1, "Box", 45)
    director.getCleanerToCleanUp(accountant)
}