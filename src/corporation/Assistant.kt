package corporation

class Assistant(
    id: Int,
    name: String,
    age: Int,
    salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    position = Position.ASSISTANT,
    salary = salary
), Cleaner, Supplier {

    override fun copy(salary: Int,age: Int): Assistant {
        return Assistant(this.id, this.name, age, salary)
    }

    override fun work() {
        println("Sirvo cafe")
    }

    override fun clean() {
        println("Mi posición es asistente. Estoy limpiando el lugar de trabajo...")
    }

    override fun buyThings() {
        println("Mi posición es asistente. Estoy haciendo compras")
    }

    fun bringCoffe (drinkName: String = "Capuccino", count: Int = 1): String {
        repeat(count) {
            println("Se levanta de su escritorio")
            println("Va hasta la cafetería")
            println("Toma un recipiente")
            println("Pone el recipiente dentro de la maquina de cafe y oprime el botón $drinkName")
            println("Espera a que el café este listo")
            println("Lleva el cafe a su jefe")
            println("Se sienta")
        }
        return "espresso"
    }
}

