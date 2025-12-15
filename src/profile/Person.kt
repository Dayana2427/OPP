package profile

data class Person(
    val name: String,
    val lastName: String,
    val height: Int,
    val weight: Int
) {

    val fullName : String
        get() = "$name $lastName\n"

    var age: Int = 0
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