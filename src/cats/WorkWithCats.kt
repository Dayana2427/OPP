package cats

fun main() {
    val cat = Cat("Sam")
    println(cat.legsCount)
    println(cat.name)
     cat.playWithMouse()

    val lion = Lion(countInPride = 15)
    println(lion.countInPride)
    println(lion.legsCount)
}