package profile

class Person(
    private val name: String,
    private val height: Float,
    private val weight: Int,
    age: Int
) {
    var age = 0
        set(value){
            if (value > field){
                field = value
            } else {
                println("La edad no puede disminuir")
            }
        }
        get(){
            println("Preguntar la edad de alguien es descortes")
            return field
        }

    fun printInfo () {
        println("Nombre: $name - Edad: $age - Altura: $height - Peso: $weight")
    }

    fun sayHello () {
        println("Hello! My name is ${this.name}")
    }

    fun running () {
        repeat(10) {
            println("Correr")
        }
    }
}