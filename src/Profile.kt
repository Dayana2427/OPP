fun main() {
    val person = Person()
    print("Ingrese su nombre 1: ")
    val name =  readln()
    print("Ingrese su edad 1: ")
    val age = readln().toInt()
    print("Ingrese su altura 1: ")
    val height = readln().toFloat()
    print("Ingrese su peso 1: ")
    val weight = readln().toInt()
    person.init(name = name, age = age, height = height, weight = weight)
    person.printInfo()
    person.sayHello()

    //println("1. Name: ${first.name} \nEdad: ${first.age} \nAltura: ${first.height} \nPeso: ${first.weight}")

    //first.sayHello()

    //first.running()
}