package corporation

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val vatios: Int
): ProductCard(name = name, brand = brand, price = price) {

    override fun printInfo() {
        super.printInfo()
        print("Vatios: $vatios")
    }
}