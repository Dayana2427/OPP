package corporation

class Director(
    id: Int,
    name: String,
    age: Int,
    salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    position = Position.DIRECTOR,
    salary = salary
), Supplier {

    override fun copy(salary: Int, age: Int): Director {
        return Director(this.id, this.name, age, salary)
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