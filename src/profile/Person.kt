package profile

class Person(
    private  val name: String,
    private  val age: Int,
    private  val height: Float,
    private  val weight: Int
) {

    fun printInfo () {
        println("Nombre: $name - Edad: $age - Altura: $height - Peso: $weight")
    }

    fun sayHello () {
        println("Hello! My name is ${this.name}")
    }

    /*fun running () {
        repeat(10) {
            println("Correr")
        }
    }*/
}