package corporation

fun main () {
    val accountant = Contador(0, "Lucas", 30)
    val employees = accountant.loadAllEmployees()
    for (employee in employees){
        if (employee is Cleaner){
            employee.clean()
        }
        if (employee is Supplier){
            employee.buyThings()
        }
    }

}