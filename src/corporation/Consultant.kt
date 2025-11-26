package corporation

import kotlin.random.Random

class Consultant (
    id: Int,
    name: String,
    age: Int = 0
): Worker(id = id, name = name, age = age, position = Position.CONSULTANT){

    override fun work() {
        println("Atiendo clientes")
    }

    fun hello (){
        print("¡Hola! Mi nombre es $name.")
        if(age > 0){
            print("Tengo $age años. \n")
        }
    }

    fun serveCustomers (): Int{
        val conteo = Random.Default.nextInt(0, 100)
        repeat(conteo){
            print("El cliente ha sido atendido... \n")
        }
        return conteo
    }
}