package corporation

 open class ProductCard(
     val name: String,
     val brand: String,
     val price: Int,
     val productType: ProductType
     ) {

    open fun printInfo (){
        println("Nombre: $name Marca: $brand Precio: $price Tipo de producto: ${productType.title}")
    }
}