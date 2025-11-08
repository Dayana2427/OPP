fun main() {
    val julia = Assistant ()
    println("La asistente se llama ${julia.name} y tiene ${julia.age} años")

    julia.bringCoffe("Americano", count = 5)
}