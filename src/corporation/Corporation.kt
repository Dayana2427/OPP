package corporation

fun main () {
    val repository = WorkersRepository
    val workers = repository.workers
    for (worker in workers){
        worker.work()
    }
}