package corporation

fun main () {
    val director = Director(name = "Lucas", age = 24)
    val consultant = Consultant(name = "Porky")
    val assistant = Assistant(name = "Petuniua", age = 20)
    director.getConsultantToWork(consultant)
    director.takeCoffe(assistant)
}