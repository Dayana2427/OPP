fun main () {
    print("Ingrese el nombre: ")
    val name = readln()
    print("Ingrese la marca: ")
    val brand = readln()
    print("Ingrese la talla: ")
    val size = readln().toFloat()
    print("Ingrese el precio: ")
    val price = readln().toInt()
    val productCar = ProductCard()
    productCar.init(name = name, brand = brand, size = size, price = price)
    productCar.printInfo()
}