package corporation

data class ApplianceCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val vatios: Int,
): ProductCard(name = name, brand = brand, price = price, ProductType.APPLIANCE)