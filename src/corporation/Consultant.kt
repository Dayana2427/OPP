package corporation

import kotlin.random.Random

class Consultant (
    id: Int,
    name: String,
    age: Int = 0,
    salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    position = Position.CONSULTANT,
    salary = salary
), Cleaner{

    override fun work() {
        serveCustomers()
    }

    override fun clean() {
        println("Mi posición es consultor. Estoy limpiando el lugar de trabajo...")
    }

    fun serveCustomers (): Int{
        val conteo = Random.nextInt(0, 100)
        repeat(conteo){
            print("El cliente ha sido atendido... \n")
        }
        println()
        return conteo
    }

    fun hello (){
        print("¡Hola! Mi nombre es $name.")
        if(age > 0){
            print("Tengo $age años. \n")
        }
    }
}