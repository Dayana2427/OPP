package corporation

import java.io.File

class Contador (
    name: String,
    age: Int
): Worker(name = name, age = age) {

    val file = File("product_card.txt")

    override fun work() {
        val codeType = CodeType.entries
        while (true) {
            print("\n Ingrese el código: ")
            for ((index, code) in codeType.withIndex()){
                print("$index - ${code.title}")
                if (index < CodeType.entries.size - 1 ) {
                    print(", ")
                }else{
                    print(": ")
                }
            }
            val operationIndex = readln().toInt()
            val codeTypes = codeType[operationIndex]
            when(codeTypes){
                CodeType.EXIT -> break
                CodeType.ENTER_PRODUCT -> registerNewItem()
                CodeType.SHOW_ALL_ITEMS -> showAllItems()
                CodeType.REMOVE_PRODUCT_CARD -> removeProductCard()
            }
        }
    }

    fun removeProductCard(){
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Ingrese el nombre de la tarjeta a eliminar: ")
        val name = readln()
        for (card in cards){
            if(card.name == name){
                cards.remove(card)
                break
            }
        }
        file.writeText("")
        for (card in cards){
            saveProductCardToFile((card))
        }
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf<ProductCard>()
        val content = file.readText().trim()
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

    fun showAllItems(){
        val cards = loadAllCards()
        for (card in cards){
            card.printInfo()
        }
    }

    fun saveProductCardToFile(productCard: ProductCard){
        file.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                val caloric = productCard.caloric
                file.appendText("$caloric%")
            }

            is ApplianceCard -> {
                val vatios = productCard.vatios
                file.appendText("$vatios%")
            }

            is ShoeCard -> {
                val size = productCard.size
                file.appendText("$size%")
            }
        }
        file.appendText("${productCard.productType}")
    }

    fun registerNewItem(){
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

