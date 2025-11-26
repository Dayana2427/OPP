package corporation

class Director(
    name: String,
    age: Int
): Worker(name = name, age = age) {

    override fun work() {
        println("Bebo cafe")
    }

    fun takeCoffe(assistant: Assistant){
        val drinkName: String = assistant.bringCoffe()
        print("Gracias ${assistant.name}, el $drinkName esta excelente")
    }

    fun getConsultantToWork (consultant: Consultant){
        val count = consultant.serveCustomers()
        print("Consultor ${consultant.name}, clientes atendidos $count ")
    }

}