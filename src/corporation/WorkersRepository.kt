package corporation

import java.io.File

class WorkersRepository {

    private val fileWorkers = File("workers.txt")

    fun registerNewEmployee(worker: Worker){
        saveWorkerToFile(worker)
    }

    fun changeSalary(id: Int, salary: Int){
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees){
            if (employee.id == id){
                employee.setSalary(salary)
            }
            saveWorkerToFile(employee)
        }
    }

    private fun saveWorkerToFile(worker: Worker){
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.position}\n")
    }

    fun fireEmployee(id: Int){
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees){
            if (employee.id != id){
                saveWorkerToFile(employee)
            }
        }
    }

    fun loadAllEmployees(): MutableList<Worker>{
        val employees = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()

        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for (employeeAsText in employeesAsText){
            val properties = employeeAsText.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val positionAsText = properties.last()
            val position = Position.valueOf(positionAsText)
            val worker = when (position){
                Position.DIRECTOR -> Director(id, name, age, salary)
                Position.ACCOUNTANT -> Contador(id, name, age, salary)
                Position.ASSISTANT -> Assistant(id, name, age, salary)
                Position.CONSULTANT -> Consultant(id, name, age, salary)
            }
            employees.add(worker)
        }
        return employees
    }
}