package cats

fun main() {
    val cat = Cat("Sam")
    val lion = Lion(countInPride = 15)
    val animals = listOf<CatsFamily>(cat, lion)
    for (animal in animals) {
        animal.eat()
    }
}