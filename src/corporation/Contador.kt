package corporation

import java.io.File

class Contador (
    id: Int,
    name: String,
    age: Int
): Worker(id, name, age, Position.ACCOUNTANT), Cleaner, Supplier {

    private val fileProductCards = File("product_card.txt")
    private val fileWorkers = File("workers.txt")

    override fun clean() {
        println("Mi posición es contador. Estoy limpiando el lugar de trabajo...")
    }

    override fun buyThings() {
        println("Mi posición es contador. Estoy haciendo compras")
    }

    override fun work() {
        val codeType = CodeType.entries
        while (true) {
            println("Ingrese el código: ")
            for ((index, code) in codeType.withIndex()){
                print("$index - ${code.title}\n")
            }
            val operationIndex = readln().toInt()
            val codeTypes = codeType[operationIndex]
            when(codeTypes){
                CodeType.EXIT -> break
                CodeType.ENTER_PRODUCT -> registerNewItem()
                CodeType.SHOW_ALL_ITEMS -> showAllItems()
                CodeType.REMOVE_PRODUCT_CARD -> removeProductCard()
                CodeType.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                CodeType.FIRE_EMPLOYEE -> fireEmployee()
                CodeType.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                CodeType.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private fun changeSalary(){
        print("Ingrese el ID del empleado para cambiar el salario: ")
        val id = readln().toInt()
        print("Ingrese el nuevo salario: ")
        val salary = readln().toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees){
            if (employee.id == id){
                employee.salary = salary
            }
            saveWorkerToFile(employee)
        }
    }

    private fun registerNewEmployee(){
        val positions = Position.entries
        print("Ingrese la posición - ")
        for ((index, position) in positions.withIndex()){
            print("$index - ${position.title}")
            if (index < positions.size - 1){
                print(", ")
            } else {
                print(": ")
            }
        }
        val positionIndex = readln().toInt()
        val position = positions[positionIndex]
        print("Ingrese el id: ")
        val id = readln().toInt()
        print("Ingrese el nombre: ")
        val name = readln()
        print("Ingrese la edad: ")
        val age = readln().toInt()
        print("Ingrese el salario: ")
        val salary = readln().toInt()
        val worker = when(position){
            Position.DIRECTOR -> Director(id, name, age)
            Position.ACCOUNTANT -> Contador(id, name, age)
            Position.ASSISTANT -> Assistant(id, name, age)
            Position.CONSULTANT -> Consultant(id, name, age)
        }
        worker.salary = salary
        saveWorkerToFile(worker)
    }

    private fun fireEmployee(){
        print("Ingrese el id del empleado a despedir: ")
        val id = readln(). toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees){
            if (employee.id != id){
                saveWorkerToFile(employee)
            }
        }

    }

    private fun showAllEmployees(){
        val employees = loadAllEmployees()
        for (employee in employees){
            employee.printInfo()
        }
    }

    fun loadAllEmployees(): MutableList<Worker>{
        val employees = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()

        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for (employeeAsText in employeesAsText){
            val properties = employeeAsText.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val positionAsText = properties.last()
            val position = Position.valueOf(positionAsText)
            val worker = when (position){
                Position.DIRECTOR -> Director(id, name, age)
                Position.ACCOUNTANT -> Contador(id, name, age)
                Position.ASSISTANT -> Assistant(id, name, age)
                Position.CONSULTANT -> Consultant(id, name, age)
            }
            worker.salary = salary
            employees.add(worker)
        }
        return employees
    }

    private fun saveWorkerToFile(worker: Worker){
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.position}\n")
    }

    private fun removeProductCard(){
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Ingrese el nombre de la tarjeta a eliminar: ")
        val name = readln()
        for (card in cards){
            if(card.name == name){
                cards.remove(card)
                break
            }
        }
        fileProductCards.writeText("")
        for (card in cards){
            saveProductCardToFile((card))
        }
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf<ProductCard>()

        if (!fileProductCards.exists()) fileProductCards.createNewFile()

        val content = fileProductCards.readText().trim()

        if (content.isEmpty()){
            return cards
        }

        val cardsAsString =content.split("\n")
        for (cardAsString in cardsAsString){
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when(productType){
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }
                ProductType.APPLIANCE -> {
                    val vatios = properties[3].toInt()
                    ApplianceCard(name, brand, price, vatios)
                }
                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    private fun showAllItems(){
        val cards = loadAllCards()
        for (card in cards){
            card.printInfo()
        }
    }

    private fun saveProductCardToFile(productCard: ProductCard){
        fileProductCards.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                val caloric = productCard.caloric
                fileProductCards.appendText("$caloric%")
            }

            is ApplianceCard -> {
                val vatios = productCard.vatios
                fileProductCards.appendText("$vatios%")
            }

            is ShoeCard -> {
                val size = productCard.size
                fileProductCards.appendText("$size%")
            }
        }
        fileProductCards.appendText("${productCard.productType}")
    }

    private fun registerNewItem(){
        val productTypes = ProductType.entries
        print("Ingrese el tipo de producto: ")
        for ((index, type) in productTypes.withIndex()){
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            }else{
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType: ProductType  = productTypes[productTypeIndex]
        print("Ingrese el nombre: ")
        val name = readln()
        print("Ingrese la marca: ")
        val brand = readln()
        print("Ingrese el precio: ")
        val price = readln().toInt()

        val card = when(productType){
            ProductType.FOOD -> {
                print("Ingrese las calorias: ")
                val caloric = readln().toInt()
                FoodCard(name, brand, price, caloric)
            }
            ProductType.APPLIANCE -> {
                print("Ingrese los vatios: ")
                val vatios = readln().toInt()
                ApplianceCard(name, brand, price, vatios)

            }
            ProductType.SHOE -> {
                print("Ingrese la talla: ")
                val size = readln().toFloat()
                ShoeCard(name, brand, price, size)
            }
        }
        saveProductCardToFile(card)
    }
}

