package profile

class Person(
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

    fun copy (name: String = this.name,
              lastName: String = this.lastName,
              height: Int = this.height,
              weight: Int = this.weight
    ) = Person (name, lastName, height, weight)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false

        if (name != other.name) return false
        if (lastName != other.lastName) return false
        if (height != other.height) return false
        if (weight != other.weight) return false


        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + height.hashCode()
        result = 31 * result + weight
        return result
    }

    override fun toString(): String {
        return "Person(name=$name, lastName=$lastName, height=$height, weight=$weight, fullName=$fullName, age=$age)"
    }


}