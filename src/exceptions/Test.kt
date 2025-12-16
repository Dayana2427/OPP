package exceptions

fun main() {
    /*try {
        val a = readln().toInt()
        val b = readln().toInt()
        println(a / b)
    } catch (exception: Throwable){
        println("Error común")
    } catch (exception: ArithmeticException){
        println("No se puede dividir entre cero")
    } catch (exception: NumberFormatException){
        println("Valor invalido")
    }
    println("Después del try-catch")*/

    try {
        val numbers = mutableListOf<Int>(0, 1, 2, 3, 4)
        println(numbers[5])
    } catch (e: Exception) {
        println("Indice incorrecto")
    }

}