package corporation

import java.io.File

object CardsRepository {

    private val fileProductCards = File("product_card.txt")
    private val _productCars = loadAllCards()
    val productCards
        get() = _productCars.toList()

    fun registerNewItem(productCard: ProductCard){
        _productCars.add(productCard)
    }

    fun removeProductCard(name: String){
        for (card in _productCars){
            if(card.name == name){
                _productCars.remove(card)
                break
            }
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

    fun saveChanges () {
        val content = StringBuilder()
        for (productCard in _productCars){
            content.append("${productCard.name}%${productCard.brand}%${productCard.price}%")
            when (productCard) {
                is FoodCard -> {
                    val caloric = productCard.caloric
                    content.append("$caloric%")
                }

                is ApplianceCard -> {
                    val vatios = productCard.vatios
                    content.append("$vatios%")
                }

                is ShoeCard -> {
                    val size = productCard.size
                    content.append("$size%")
                }
            }
            content.append("${productCard.productType}")
        }
        fileProductCards.writeText(content.toString())
    }
}