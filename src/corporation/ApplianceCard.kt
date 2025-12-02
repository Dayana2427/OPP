package corporation

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val vatios: Int,
): ProductCard(name = name, brand = brand, price = price, ProductType.APPLIANCE) {

    override fun toString(): String {
        return "Nombre: $name Marca: $brand Precio: $price Tipo de producto: ${productType.title} Vatios: $vatios \n"
    }
}