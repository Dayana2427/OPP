class ProductCard(val name: String,
                  val brand: String,
                  val size: Float,
                  val price: Int
) {

    fun printInfo (){
        println("Nombre: $name Marca: $brand  Talla: $size  Precio: $price")
    }
}