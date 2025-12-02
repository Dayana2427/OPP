package corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
): ProductCard(name = name, brand = brand, price = price, ProductType.SHOE) {

    override fun toString(): String {
        return "Nombre: $name Marca: $brand Precio: $price Tipo de producto: ${productType.title} Talla: $size \n"
    }
}