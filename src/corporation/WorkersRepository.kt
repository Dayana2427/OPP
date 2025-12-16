package corporation

import java.io.File

object WorkersRepository {

    private val fileWorkers = File("workers.txt")
    private val _workers = loadAllEmployees()
    val workers
        get() = _workers.toList()

    fun registerNewEmployee(newWorker: Worker){
        _workers.add(newWorker)
    }

    fun findAssistant(): Assistant?{
        for (worker in _workers){
            if (worker is Assistant){
                return worker
            }
        }
        return null
    }

    fun findDirector(): Director? {
        for (worker in _workers){
            if (worker is Director)
                return worker
        }
        return null
    }

    fun changeAge(id: Int, age: Int){
        for (worker in _workers){
            if (worker.id == id){
                val newWorker = worker.copy(age = age)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun changeSalary(id: Int, salary: Int){
        for (worker in _workers){
            if (worker.id == id){
                val newWorker = worker.copy(salary = salary)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun saveChanges (){
        val content = StringBuilder()
        for (worker in _workers){
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.position}\n")
        }
        fileWorkers.writeText(content.toString())
    }

    fun fireEmployee(id: Int) {
        for (worker in _workers){
            if (worker.id == id){
                _workers.remove(worker)
                break
            }
        }
    }

    private fun saveWorkerToFile(worker: Worker){
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.position}%${worker.salary}\n")
    }

    private fun loadAllEmployees(): MutableSet <Worker>{
        println("loadAllEmployees")
        val employees = mutableSetOf<Worker>()

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