package files

import java.io.File

fun main() {
    val codeType = CodeType.entries
    val file = File("todo_list.txt")
    while (true){
        print("Ingrese el código de operación. ")
        for ((index, code) in codeType.withIndex()){
            print("$index - ${code.title}")
            if (index < corporation.CodeType.entries.size - 1 ) {
                print(", ")
            }else{
                print(": ")
            }
        }
        val operationIndex = readln().toInt()
        val codeTypes = codeType[operationIndex]
        when(codeTypes){
            CodeType.EXIT -> break
            CodeType.ENTER_TASK -> {
                print("Ingrese un nuevo item: ")
                val item = readln()
                file.appendText("$item\n")
            }
            CodeType.SHOW_TASKS -> {
                val content = file.readText().trim()
                val items = content.split("\n")
                for ((index, item) in items.withIndex()){
                    println("$index - $item")
                }
            }
        }
    }

}