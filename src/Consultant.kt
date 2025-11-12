import kotlin.math.sign
import kotlin.random.Random

class Consultant (
    val name: String,
    val age: Int = 0
){
    fun hello (){
        print("¡Hola! Mi nombre es $name.")
        if(age > 0){
           print("Tengo $age años. \n")
        }
    }

    fun serveCustomers (): Int{
        val conteo = Random.nextInt(0, 100)
        repeat(conteo){
            print("El cliente ha sido atendido... \n")
        }
        return conteo
    }
}