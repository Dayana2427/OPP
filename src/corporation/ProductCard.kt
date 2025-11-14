package corporation

 open class ProductCard(
     val name: String,
     val brand: String,
     val price: Int,
     ) {

    open fun printInfo (){
        println("Nombre: $name Marca: $brand Precio: $price")
    }
}