package corporation

class FoodCard (
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
): ProductCard(name = name, brand = brand, price = price, ProductType.FOOD) {
    override fun printInfo() {
        println("Nombre: $name Marca: $brand Precio: $price Tipo de producto: ${productType.title} Calorias: $caloric \n")
    }
}