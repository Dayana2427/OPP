package cats

class Cat(val name: String): CatsFamily() {
    fun playWithMouse (){
        println("Estoy jugando con el raton")
    }
}