class Person  {
    var name: String = ""
    var age: Int = 0
    var height = 0F
    var weight = 0

    fun init (name: String, age: Int, height: Float, weight: Int) {
        this.name = name
        this.age = age
        this.height = height
        this.weight = weight
    }

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