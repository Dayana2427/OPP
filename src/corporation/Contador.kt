package corporation

data class Contador (
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
): Worker(
    id,
    name,
    age,
    salary,
    Position.ACCOUNTANT
), Cleaner, Supplier {

    private val workersRepository = WorkersRepository
    private val cardsRepository = CardsRepository

    override fun clean() {
        println("Mi posición es contador. Estoy limpiando el lugar de trabajo...")
    }

    override fun buyThings() {
        println("Mi posición es contador. Estoy haciendo compras")
    }

    override fun work() {
        val codeType = CodeType.entries
        while (true) {
            println("\nIngrese el código: ")
            for ((index, code) in codeType.withIndex()){
                print("$index - ${code.title}\n")
            }
            val operationIndex = readln().toInt()
            val codeTypes = codeType[operationIndex]
            when(codeTypes){
                CodeType.EXIT -> {
                    workersRepository.saveChanges()
                    break
                }
                CodeType.ENTER_PRODUCT -> registerNewItem()
                CodeType.SHOW_ALL_ITEMS -> showAllItems()
                CodeType.REMOVE_PRODUCT_CARD -> removeProductCard()
                CodeType.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                CodeType.FIRE_EMPLOYEE -> fireEmployee()
                CodeType.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                CodeType.CHANGE_SALARY -> changeSalary()
                CodeType.CHANGE_AGE -> changeAge()
            }
        }
    }

    private fun changeAge(){
        print("Ingrese el ID del empleado para cambiar la edad: ")
        val id = readln().toInt()
        print("Ingrese la nueva edad: ")
        val age = readln().toInt()
        workersRepository.changeAge(id, age)
    }

    private fun changeSalary(){
        print("Ingrese el ID del empleado para cambiar el salario: ")
        val id = readln().toInt()
        print("Ingrese el nuevo salario: ")
        val salary = readln().toInt()
        workersRepository.changeSalary(id, salary)
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
            Position.DIRECTOR -> Director(id, name, age, salary)
            Position.ACCOUNTANT -> Contador(id, name, age, salary)
            Position.ASSISTANT -> Assistant(id, name, age, salary)
            Position.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployee(worker)
    }

    override fun copy(id: Int, name: String, age: Int, salary: Int, position: Position): Worker {
        return Contador(id = id, name = name, age = age, salary = salary)
    }

    private fun fireEmployee(){
        print("Ingrese el ID del empleado a despedir: ")
        val id = readln().toInt()
        workersRepository. fireEmployee(id)
    }

    private fun showAllEmployees(){
        val employees = workersRepository.workers
        for (employee in employees){
            employee.printInfo()
        }
    }

    private fun removeProductCard(){
        print("Ingrese el nombre de la tarjeta a eliminar: ")
        val name = readln()
        cardsRepository.removeProductCard(name )
    }

    private fun showAllItems(){
        val cards = cardsRepository.productCards
        for (card in cards){
            card.printInfo()
        }
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
        cardsRepository.registerNewItem(card)
    }
}

