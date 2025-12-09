package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int  = 0,
    val position: Position
){

    var salary: Int = 15000
        set(value){
            if (value < field){
                println("El nuevo salario es menor al anterior...")
            } else {
            field = value
            }
        }


    /*fun setSalary (salary: Int){
        if (salary < this.salary){
            println("El nuevo salario es menor al anterior...")
        } else {
            this.salary = salary
        }
    }

    fun getSalary(): Int {
        return this.salary
    }*/

    abstract fun work()

    fun printInfo(){
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Posición: $position Salario: $salary"
    }
}