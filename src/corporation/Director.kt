package corporation

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    position = Position.DIRECTOR,
    salary = salary
), Supplier {

    override fun copy(id: Int, name: String, age: Int, salary: Int, position: Position): Worker {
        return Contador(id = id, name = name, age = age, salary = salary)
    }

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