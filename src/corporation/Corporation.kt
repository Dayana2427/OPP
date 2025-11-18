package corporation

fun main () {
    val director = Director(name = "Lucas", age = 24)
    val consultant  = Consultant(name = "Porky")
    val assistant = Assistant(name = "Petunia", age = 20)
    val contador = Contador (name = "Pepe", age = 38)
    val employees = listOf<Worker>(director, assistant, consultant, contador)
    for (employee in employees){
        employee.work()
    }
}