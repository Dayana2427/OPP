class Assistant(
    val name: String
) {

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