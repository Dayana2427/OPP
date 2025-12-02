package corporation

class Director(
    id: Int,
    name: String,
    age: Int
): Worker(id = id, name = name, age = age, position = Position.DIRECTOR), Supplier {

    override fun work() {
        println("Bebo cafe")
    }

    fun getCleanerToCleanUp(cleaner: Cleaner){
        cleaner.clean()
    }

    override fun buyThings() {
        println("Mi posición es director. Estoy haciendo compras")
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