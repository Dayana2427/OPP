package corporation

class Contador (
    name: String,
    age: Int
): Worker(name = name, age = age) {

    override fun work() {
        while (true) {
            print("Ingrese código 0 para salir o 1 para agregar tarjeta de producto: ")
            val operation = readln().toInt()
            when(operation){
                0 -> break
                1 -> registerNewItem()
            }
        }
    }

    fun registerNewItem(){
        print("Ingrese su código de operación. 0 Alimentos, 1 Electrodomesticos o 2 para Zapatos: ")
        val productType = readln().toInt()
        print("Ingrese el nombre: ")
        val name = readln()
        print("Ingrese la marca: ")
        val brand = readln()
        print("Ingrese el precio: ")
        val price = readln().toInt()
        val card = when(productType){
            0 -> {
                print("Ingrese las calorias: ")
                val caloric = readln().toInt()
                FoodCard(
                    name = name,
                    brand = brand,
                    price = price,
                    caloric = caloric
                )
            }
            1 -> {
                print("Ingrese los vatios: ")
                val vatios = readln().toInt()
                ApplianceCard(
                    name = name,
                    brand = brand,
                    price = price,
                    vatios = vatios
                )
            }
            else -> {
                print("Ingrese la talla: ")
                val talla = readln().toFloat()
                ShoeCard(
                    name = name,
                    brand = brand,
                    price = price,
                    size = talla
                )
            }
        }
        card.printInfo()
    }
}

